package br.com.bandas.api.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;



import br.com.bandas.business.user.UserService;
import br.com.bandas.business.user.UserServiceImpl;
import br.com.bandas.jpa.entities.User;

@Path("/users")
public class UserController extends ControllerUtil{

	
	private UserService userService = new UserServiceImpl();
	
	
	@POST
	public Response addUser(User user) {
		
		
		try{
			
			User savedUser = userService.save(user); 
			return this.buildResponse(savedUser);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
			
		}
		
		
	}

	
	@GET
	@Path("/{id}")
	public Response getUser(@PathParam("id") Integer id) {
		
		
		try{
			
			User user = userService.getById(id);
			return this.buildResponse(user);
			
			
		}catch (Exception e) {
			
			
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		
		
		}
		
		
	}
	
	@PUT
	public Response updateUser(User user) {
		
		try{
			
			userService.update(user);
			return this.buildResponse(user);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		
		}
		
		
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Integer id) {
		
		
		try{
			
			
			User result = userService.getById(id);
			userService.delete(result);
			return this.buildResponse("Deleted user successfully.");
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
			
			
		}
		
		
		
	}
	
	
}

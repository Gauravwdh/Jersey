package com.gaurav.UserImage;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.gaurav.UserImage.user.User;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

  private static HashMap<Integer, User> map = new HashMap<>();

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/user")
  public Response addUser(User user) {
    map.put(user.getId(), user);
    ResponseBuilder response = Response.accepted();
    return response.build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{id}")
  public User getUser(@PathParam("id") int id) {
    User user = new User();
    user.setId(1);
    user.setName("Gaurav");
    return user;
  }

}

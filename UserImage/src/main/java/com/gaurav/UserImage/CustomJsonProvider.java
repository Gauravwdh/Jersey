package com.gaurav.UserImage;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author <a href="mailto:sumved.shami@akosha.in">Sumved Shami</a>
 *
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CustomJsonProvider implements ContextResolver<ObjectMapper> {

  private static ObjectMapper objectMapper = new ObjectMapper();

  static {

    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  @Override
  public ObjectMapper getContext(Class<?> arg0) {
    // TODO Auto-generated method stub
    return objectMapper;
  }
}

package com.slotegrator.framework.converter;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class FileConverter {

  public static <T> T resouceFileToObject(String filePath, Class<T> clazz) {
    InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
    if (resourceAsStream == null) {
      throw new RuntimeException("Resource not found: " + filePath);
    }
    try {
      return new ObjectMapper(new YAMLFactory()).readValue(resourceAsStream, clazz);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read resource " + filePath, e);
    }
  }
}

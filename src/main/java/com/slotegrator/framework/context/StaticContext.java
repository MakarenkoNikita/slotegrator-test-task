package com.slotegrator.framework.context;

import static com.slotegrator.framework.converter.FileConverter.resouceFileToObject;

import com.slotegrator.application.entity.model.EnvironmentConfiguration;

public class StaticContext {

  public static EnvironmentConfiguration environmentConfiguration = resouceFileToObject(
      "application/envConfiguration.yaml", EnvironmentConfiguration.class
  );
}

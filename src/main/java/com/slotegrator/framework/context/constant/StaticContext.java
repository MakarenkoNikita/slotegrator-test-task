package com.slotegrator.framework.context.constant;

import static com.slotegrator.framework.converter.FileConverter.resouceFileToObject;

public class StaticContext {

  public static EnvironmentConfiguration environmentConfiguration = resouceFileToObject(
      "application/envConfiguration.yaml", EnvironmentConfiguration.class
  );
}

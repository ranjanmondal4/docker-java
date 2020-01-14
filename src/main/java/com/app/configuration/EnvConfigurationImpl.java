package com.app.configuration;

import org.springframework.beans.factory.annotation.Value;

public class EnvConfigurationImpl implements EnvConfiguration {

	//private ServiceLocator serviceLocator = ServiceLocator.getInstance();

	@Value("${server.port}")
	private String SERVER_PORT;

	@Value("${spring.application.name}")
	private String APPLICATION_NAME;

	private static final String DATASOURCE_URL = "datasource-url";
	private static final String DATASOURCE_PASSWORD = "datasource-password";
	private static final String DATASOURCE_USER_NAME = "datasource-user-name";
	private static final String HIBERNATE_DDL_AUTO = "hibernate-ddl-auto";

	@Override
	public String getServerPort() {
		return SERVER_PORT;
	}

	@Override
	public String getApplicationName() {
		return APPLICATION_NAME;
	}

//	@Override
//	public String getDatasourceUrl() {
//		return serviceLocator.getValueAsPerKey(DATASOURCE_URL);
//	}
//
//	@Override
//	public String getDatasourceUserName() {
//		return serviceLocator.getValueAsPerKey(DATASOURCE_USER_NAME);
//	}
//
//	@Override
//	public String getDatasourcePassword() {
//		return serviceLocator.getValueAsPerKey(DATASOURCE_PASSWORD);
//	}
//
//	@Override
//	public String getHibernateDdlAuto() {
//		return serviceLocator.getValueAsPerKey(HIBERNATE_DDL_AUTO);
//	}

}

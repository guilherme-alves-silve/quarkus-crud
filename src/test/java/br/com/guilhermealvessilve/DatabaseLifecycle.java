package br.com.guilhermealvessilve;

import java.util.Map;

import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DatabaseLifecycle implements QuarkusTestResourceLifecycleManager {

	private static final MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql/mysql-server:8.0.19"); 
	
	@Override
	public Map<String, String> start() {
		MYSQL.start();
		final var properties = Map.of(
			"quarkus.datasource.url", MYSQL.getJdbcUrl(),
			"quarkus.datasource.username", MYSQL.getUsername(),
			"quarkus.datasource.password", MYSQL.getPassword()
		);
		return properties;
	}

	@Override
	public void stop() {
		if (MYSQL != null) {
			MYSQL.stop();
		}
	}

}

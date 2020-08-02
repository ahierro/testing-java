package com.example.testingjava.junit4;

import org.testcontainers.containers.PostgreSQLContainer;

public class ConfigPostgresqlContainer extends PostgreSQLContainer<ConfigPostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:11.1";

    private static ConfigPostgresqlContainer container;


    private ConfigPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static ConfigPostgresqlContainer getInstance() {
        if (container == null) {
            container = new ConfigPostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}

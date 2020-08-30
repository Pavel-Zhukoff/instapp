package ru.instapp.instapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.instapp.instapp.properties.DataSourceProperties;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource DataSourceConfiguration() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName(dataSourceProperties.getDriver());
        builder.url(dataSourceProperties.getUrlWithSchema());
        builder.username(dataSourceProperties.getUsername());
        builder.password(dataSourceProperties.getPassword());
        return builder.build();
    }
}

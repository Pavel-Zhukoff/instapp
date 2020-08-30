package ru.instapp.instapp.properties;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class DataSourceProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceProperties.class);

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.default-schema}")
    private String schema;

    @Value("${spring.datasource.driverClassName}")
    private String driver;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public String getUrlWithSchema() {
        return String.format("%s?currentSchema=%s", url, schema);
    }
}

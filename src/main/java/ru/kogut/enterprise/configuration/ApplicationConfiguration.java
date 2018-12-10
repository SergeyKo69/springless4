package ru.kogut.enterprise.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("ru.kogut.enterprise")
@EnableJpaRepositories("ru.kogut.enterprise.repository")
@Import(DataSourceConfiguration.class)
public class ApplicationConfiguration {
}

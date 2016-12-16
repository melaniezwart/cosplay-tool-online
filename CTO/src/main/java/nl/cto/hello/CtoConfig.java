package nl.cto.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by mzwart on 9-12-2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"nl.cto.repository"})
@ComponentScan({"nl.cto"})
public class CtoConfig {
}

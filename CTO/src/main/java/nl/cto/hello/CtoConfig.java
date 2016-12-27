package nl.cto.hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
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

/*	@Bean
	public Session getSession() throws Exception{
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		configuration.configure("hibernate_sp.cfg.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
		Session session = sessionFactory.openSession();
		return session;
	}*/

/*	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("nl.cto");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		factory.setJpaProperties(additionalProperties());
		return factory.getObject();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/CTO");
		dataSource.setUsername("cto");
		dataSource.setPassword("cto");
		return dataSource;
	}

	Properties additionalProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}*/
}

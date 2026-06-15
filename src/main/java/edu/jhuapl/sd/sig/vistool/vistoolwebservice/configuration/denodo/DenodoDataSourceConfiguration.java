package edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.denodo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "denodoEntityManagerFactory",
		transactionManagerRef = "denodoTransactionManager",
		basePackages = { "edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo" }
)
public class DenodoDataSourceConfiguration {

	@Bean(name="denodoDataSource")
	@ConfigurationProperties(prefix = "denodo.datasource")
	public DataSource denodoDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "denodoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean denodoEntityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("denodoDataSource") DataSource dataSource) {

		HashMap<String, Object> props = new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.put("hibernate.hbm2ddl.auto", "create");

		return builder
				.dataSource(dataSource)
				.packages("edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo")
				.persistenceUnit("denodo")
				.properties(props)
				.build();
	}

	@Bean(name="denodoTransactionManager")
	public PlatformTransactionManager denodoTransactionManager(
			@Qualifier("denodoEntityManagerFactory") EntityManagerFactory
					denodoEntityManagerFactory
	) {
		return new JpaTransactionManager(denodoEntityManagerFactory);
	}
}

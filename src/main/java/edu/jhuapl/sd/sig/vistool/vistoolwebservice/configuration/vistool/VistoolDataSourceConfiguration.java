package edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.vistool;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
		entityManagerFactoryRef = "vistoolEntityManagerFactory",
		transactionManagerRef = "vistoolTransactionManager",
		basePackages = { "edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool" }
)
public class VistoolDataSourceConfiguration {
	@Value("${vistool.datasource.hibernate.dialect}")
	private String hibernateDialect;

	@Primary
	@Bean(name="vistoolDataSource")
	@ConfigurationProperties(prefix = "vistool.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "vistoolEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("vistoolDataSource") DataSource dataSource) {

		HashMap<String, Object> props = new HashMap<>();
		props.put("hibernate.dialect", hibernateDialect);

		return builder
				.dataSource(dataSource)
				.packages("edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool")
				.persistenceUnit("vistool")
				.properties(props)
				.build();
	}

	@Primary
	@Bean(name="vistoolTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("vistoolEntityManagerFactory") EntityManagerFactory
					entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
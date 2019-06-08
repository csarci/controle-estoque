package br.com.gm5.estoque;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@EnableJpaRepositories
public class Configuration {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/controle_estoque?useTimezone=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("vert1234");
		
		return dataSource;
	}

}

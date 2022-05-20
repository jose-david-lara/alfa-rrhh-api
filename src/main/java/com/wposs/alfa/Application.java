package com.wposs.alfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,  DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableScheduling
@EnableAsync
@ComponentScan( basePackages = { "com.wposs.*, com.wposs.alfa.rrhh" } )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run( Application.class, args);
		
		/*if(args.length == 0) {
			BaseSpringApplication.start(Application.class, args);
		}else {
			try {
				AlfaUtils.main(args);
			} catch (Exception e) {
				AppLogger.error(e);
			}
		}*/
		
	}

}

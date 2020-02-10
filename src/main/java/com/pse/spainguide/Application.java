package com.pse.spainguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.pse.spainguide.configuration.FileStorageConfiguration;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageConfiguration.class
})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

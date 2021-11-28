package app.willywonkastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication 
@EnableConfigurationProperties
@EntityScan(basePackages = {"app.willywonkastore.Model"})
public class WillywonkastoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WillywonkastoreApplication.class, args);
	}

}

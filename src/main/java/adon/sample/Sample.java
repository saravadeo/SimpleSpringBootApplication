package adon.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@ComponentScan(basePackages = { "adon.sample" })
@EntityScan(basePackages = { "adon.sample" })
@EnableJpaRepositories(basePackages = {"adon.sample"})
public class Sample {
	
	public static void main(String [] args) {
		SpringApplication.run(Sample.class, args);
	}
}

package padoca.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"padoca.backend.models"})
@ComponentScan(basePackages = {"padoca.*"})
@EnableJpaRepositories(basePackages = {"padoca.backend.repositories"})
@EnableTransactionManagement
@EnableWebMvc
public class BackendpadocaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendpadocaApplication.class, args);
	}

}

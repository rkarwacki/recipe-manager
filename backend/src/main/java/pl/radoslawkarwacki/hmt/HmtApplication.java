package pl.radoslawkarwacki.hmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.radoslawkarwacki.hmt.controller.RecipeController;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"pl.radoslawkarwacki.hmt.controller", "pl.radoslawkarwacki.hmt.repository", "pl.radoslawkarwacki.hmt.service"})
public class HmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmtApplication.class, args);
	}

}

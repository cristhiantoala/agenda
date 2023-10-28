package dagatecompany.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
=======
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;
>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63

@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
<<<<<<< HEAD

=======
	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}
>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
}

package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application.yaml")
public class TextParseServiceApplication {

	@Value("${server.port}")
	private static int port;
	public static void main(String[] args) {
		SpringApplication.run(TextParseServiceApplication.class, args);
		System.out.println(port);
	}

}

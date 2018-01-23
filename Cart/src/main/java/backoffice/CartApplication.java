package backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.cart.backoffice","Repo","RestApi"})
public class CartApplication {
	// Omkar
	// Omkar 2
	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}
}

package final.BankSystem; // Adjust the package based on your project structure

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow cross-origin requests from your front-end
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // Change this if your front-end is hosted elsewhere
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // You can customize allowed methods
                .allowCredentials(true);  // If you need to send credentials like cookies or headers
    }
}

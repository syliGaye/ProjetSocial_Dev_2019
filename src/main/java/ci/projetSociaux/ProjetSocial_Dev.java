package ci.projetSociaux;

import ci.projetSociaux.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ProjetSocial_Dev extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjetSocial_Dev.class, args);
	}
        
        @Override
        protected SpringApplicationBuilder configure ( SpringApplicationBuilder builder){
        return builder.sources(ProjetSocial_Dev.class);
        }
        
}

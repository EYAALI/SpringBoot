package tn.esprit.tpfoyer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SpringDoc-foyer")
                        .version("1.0")
                        .description("Description de tp foyer")
                        .termsOfService("sevice")
                        .contact(new Contact()
                                .name("Malek")
                                .email("malek.bdiri@esprit.tn")
                                .url("http://google.com")

                                )

                );
    }
   // @Bean
   // public GroupedOpenApi BlocManagement()
  //  {
      //  return GroupedOpenApi.builder().pathsToMatch("/api/blocs/**").pathsToExclude("**").group("Bloc Management").displayName("Bloc Management").build();
  //  }
}

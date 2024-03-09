package com.qburry.kapi;

import com.qburry.kapi.service.AuthenticationService;
import com.qburry.kapi.user.dto.Account;
import com.qburry.kapi.user.dto.Gender;
import com.qburry.kapi.user.dto.User;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Library API", version = "1.0.0", description = "Library api management."
        )
)
@SpringBootApplication
public class KapiApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(KapiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AuthenticationService authenticationService) {
        return args -> users.forEach(authenticationService::signup);
    }

    List<User> users = List.of(
            User.builder().firstname("Kevin").lastname("Az").email("kevin@az.de").mobile("1234567").gender(Gender.MALE).role("ADMIN")
                    .account(Account.builder().username("kaz").password("password").salt("salt1").hash("hash").build()).build(),
            User.builder().firstname("John").lastname("Doe").email("john@doe.de").mobile("1234567").gender(Gender.MALE).role("CREATOR")
                    .account(Account.builder().username("j.doe").password("password").salt("salt2").hash("hash").build()).build(),
            User.builder().firstname("Jane").lastname("Doe").email("janen@doe.de").mobile("1234567").gender(Gender.FEMALE).role("EDITOR")
                    .account(Account.builder().username("doe").password("password").salt("salt3").hash("hash").build()).build(),
            User.builder().firstname("Obi").lastname("Kenobi").email("kenobi@kubes.de").mobile("1234567").gender(Gender.UNDEFINED).role("USER")
                    .account(Account.builder().username("obi").password("password").salt("salt4").hash("hash").build()).build()
    );
}

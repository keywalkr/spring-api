package com.qburry.kubesspring.springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiApplication.class, args);
    }

    //@Bean
    //CommandLineRunner commandLineRunner(PersonService personService) {
      //  return args -> {
          //personService.save(new Person(1, "Spring", "Boot", "email","mobile")) ;
       // };
    //}

}

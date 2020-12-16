package net.openwebinars.proyectothymeleaf;

import io.netty.util.internal.ThreadLocalRandom;
import net.openwebinars.proyectothymeleaf.model.User;
import net.openwebinars.proyectothymeleaf.repositories.UserRepository;
import net.openwebinars.proyectothymeleaf.upload.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class ProyectothymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectothymeleafApplication.class, args);
    }
    /*@Bean
    CommandLineRunner init(StorageService storageService){
        return (args) ->{
            //storageService.deleteAll();
            //storageService.init();
        };
    }*/

   @Bean
    CommandLineRunner initData(UserRepository userRepository){
        return (args)->{
            /*List<String> nombres = Arrays.asList("Lucas", "Hugo", "Martín", "Daniel", "Pablo", "Alejandro", "Mateo",
                    "Adrián", "Álvaro", "Manuel", "Leo", "David", "Mario", "Diego", "Javier", "Luis", "Marcos", "Juan",
                    "José", "Gonzalo", "Lucía", "Sofía", "María", "Martina", "Paula", "Julia", "Daniela", "Valeria",
                    "Alba", "Emma", "Carla", "Sara", "Noa", "Carmen", "Claudia", "Valentina", "Alma", "Ana", "Luisa",
                    "Marta");

            List<String> apellidos = Arrays.asList("García", "González", "López", "Rodríguez", "Martínez", "Sánchez",
                    "Pérez", "Gómez", "Martín", "Saez", "Velasco", "Moya", "Soler", "Parra", "Bravo", "Rojas", "Romero",
                    "Sosa", "Torres", "Álvarez", "Flores", "Molina", "Ortiz", "Silva", "Torres");



            Collections.shuffle(nombres);

            userRepository.saveAll(IntStream.rangeClosed(1, nombres.size()).mapToObj((i) -> {
                String nombre = nombres.get(i-1);
                String apellido1 = apellidos.get(ThreadLocalRandom.current().nextInt(apellidos.size()));
                String apellido2 = apellidos.get(ThreadLocalRandom.current().nextInt(apellidos.size()));
                new User("","","","","","");
                return new User(nombre, apellido1 ,String.format("%s.%s@openwebinars.net", nombre.toLowerCase(), apellido1.toLowerCase()), nombre.substring(0,3).toLowerCase(Locale.ROOT)+apellido1.substring(0,3).toLowerCase(Locale.ROOT),"1234",null);
            }).collect(Collectors.toList()));*/
        };
    }
}

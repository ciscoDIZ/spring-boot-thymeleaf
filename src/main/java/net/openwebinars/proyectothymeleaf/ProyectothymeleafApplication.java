package net.openwebinars.proyectothymeleaf;

import net.openwebinars.proyectothymeleaf.upload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectothymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectothymeleafApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService){
        return (args) ->{
            storageService.deleteAll();
            storageService.init();
        };
    }
}

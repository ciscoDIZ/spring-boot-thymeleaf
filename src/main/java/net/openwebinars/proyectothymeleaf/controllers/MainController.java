package net.openwebinars.proyectothymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/saludo")
    public String welcome(@RequestParam("nombre") Optional<String> nombre, Model model){
        model.addAttribute("nombre", nombre.orElse("Juapo"));
        return "index";
    }

    @GetMapping("/")
    public String index(@RequestParam(name = "nombre", required = false, defaultValue = "Juapo") String nombre,
                        @RequestParam(name = "apellido", required = false, defaultValue = "Juapisimo") String apellido, Model model){
        model.addAttribute("nombre",nombre);
        model.addAttribute("apellido", apellido);
        return "index";
    }

}

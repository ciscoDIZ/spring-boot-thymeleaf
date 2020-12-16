package net.openwebinars.proyectothymeleaf.controllers;

import net.openwebinars.proyectothymeleaf.model.User;

import net.openwebinars.proyectothymeleaf.services.UserService;
import net.openwebinars.proyectothymeleaf.upload.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StorageService storageService;

    @GetMapping( "/user/list")
    public String listado(Model model){
        model.addAttribute("listUsers", userService.findAll());
        model.addAttribute("apellido", "Juapisimo");
        return "list-user";
    }

    @GetMapping("/user/new")
    public String nuevoUsuarioForm(Model model){
        model.addAttribute("userForm", new User());
        model.addAttribute("apellido", "Juapisimo");
        return "form-user";
    }

    @GetMapping("/user/edit/{id}")
    public String editUsuarioForm(@PathVariable long id, Model model){
        String redirect;
        User user = userService.findById(id);
        redirect = (user != null) ? "form-user" : "redirect:/user/new";
        model.addAttribute("userForm", user);
        return redirect;
    }

    @PostMapping("/user/new/submit")
    public String nuevoUsuarioSubmit(@ModelAttribute("userForm") @Valid User newUser,
                                     BindingResult result,
                                     @RequestParam("file") MultipartFile file){
        String redirect;
        if(result.hasErrors()){
            redirect = "form-user";
        }else{
            if(!file.isEmpty()){
                String avatar = storageService.store(file, newUser.getId());
                newUser.setImagen(MvcUriComponentsBuilder
                        .fromMethodName(UserController.class, "serveFile", avatar).build().toString());
            }
            redirect = "redirect:/user/list/";
            userService.addUser(newUser);
        }
        return redirect;
    }

    @PostMapping("/user/edit/submit")
    public String editUsuarioSubmit(@ModelAttribute("userForm") @Valid User user, BindingResult result){
        String redirect;
        if(result.hasErrors()){
            redirect = "form-user";
        }else{
            redirect = "redirect:/user/list/";
            userService.addUser(user);
        }
        return redirect;
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }
}

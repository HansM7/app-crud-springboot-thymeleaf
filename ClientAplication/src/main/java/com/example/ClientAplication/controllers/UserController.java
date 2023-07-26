package com.example.ClientAplication.controllers;

import com.example.ClientAplication.DTO.ApiResponse;
import com.example.ClientAplication.DTO.EditDTO;
import com.example.ClientAplication.DTO.PostDTO;
import com.example.ClientAplication.DTO.UserDTO;
import com.example.ClientAplication.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    @Autowired
    private HttpServletRequest request;
    
    @GetMapping("/")
    public String findAll(Model model){
        List<UserDTO> userDTOS = userService.findAll();
        model.addAttribute("users",userDTOS);
        return  "users";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new PostDTO());
        return  "create";
    }

    @PostMapping("/create")
    public String save(
            @Valid @ModelAttribute("user") PostDTO postDTO,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "create";
        }

        ApiResponse<?> apiResponse =  userService.createOne(postDTO);

        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Integer id,
            Model model
    ){
        EditDTO editDTO = userService.findOne(id);
        model.addAttribute("user",editDTO);
        return "edit";
    }


    @PostMapping("/edit")
    public String edit(
            Model model,
            @Valid @ModelAttribute("user") EditDTO editDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ){
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Hubo errores en el formulario. Por favor, corrija los campos marcados.");
            String referrer = request.getHeader("referer");
            return "redirect:" + referrer;
        }

        ApiResponse<?> apiResponse =  userService.editOne(editDTO);

        return "redirect:/";

    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") Integer id
    ){
        userService.deleteOne(id);
        return "redirect:/";
    }
    
}

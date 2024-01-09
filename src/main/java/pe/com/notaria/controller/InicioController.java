package pe.com.notaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {
    
    @GetMapping
    public String MostrarInicio(){
        return "index";
    }
    
    //metodo validar que recibe los valores desde el formulario que se encuentra
    //en el index
    @PostMapping("/validar")
    //para almacenar los valores que vienen del index --> cajas de texto
    //utilizamos la anotacion @RequestParam, que deben de tener el mismo nombre
    //de las cajas de texto del formulario
    public String ValidarUsuario(@RequestParam String nombres,
            @RequestParam String apellidos, 
            @RequestParam String email, 
            @RequestParam String celular) {
        //comparamos los valores recibidos desde el formulario
        if (nombres.equals("julio") && 
                apellidos.equals("cabello") && 
                email.equals("julio@cabello") && 
                celular.equals("123456789")) {
            //redireccionamos hacia el menu principal
            return "redirect:/menuprincipal";
        } else {
            //redireccionamos al login --> index
            return "redirect:/";
        }

    }

    @GetMapping("/menuprincipal")
    public String MostrarMenu() {
        return "principal";
    }
}

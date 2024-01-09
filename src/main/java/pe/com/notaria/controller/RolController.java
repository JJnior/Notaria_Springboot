package pe.com.notaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.notaria.entity.RolEntity;
import pe.com.notaria.service.seguridad.RolService;

@Controller
public class RolController {
    @Autowired
    private RolService servicio;
    
    @GetMapping("/rol")
    public String MostrarRol(Model modelo) {
        modelo.addAttribute("roles",
                servicio.findAllCustom());
        return "rol";
    }
    
    @GetMapping("/registrarrol")
    public String MostrarRegistrarRol() {
        return "rol/registrarrol";
    }
    @ModelAttribute("rol")
    public RolEntity ModeloRol() {
        return new RolEntity();
    }
    @PostMapping("/registrarrol")
    public String RegistrarRol(
            @ModelAttribute("rol") RolEntity r) {
        servicio.add(r);
        return "redirect:/rol";
    }
    
    @GetMapping("/actualizarrol/{id}")
    public String MostrarActualizarRol(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("roles",
                servicio.findById(id).get());
        return "rol/actualizarrol";
    }
    @PostMapping("/actualizarrol/{id}")
    public String ActualizarRol(@PathVariable Long id,
            @ModelAttribute("rol") RolEntity r) {
        servicio.update(r);
        return "redirect:/rol";
    }
    
    @GetMapping("/eliminarrol/{id}")
    public String EliminarRol(@PathVariable Long id) {
        RolEntity objrol = servicio.findById(id).get();
        servicio.delete(objrol);
        return "redirect:/rol";
    }
    
    @GetMapping("/habiltacionrol")
    public String MostrarHabilitarRol(Model modelo) {
        modelo.addAttribute("roles",
                servicio.findAll());
        return "rol/habilitarrol";
    }
    @GetMapping("/habilitarrol/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        RolEntity objrol = servicio.findById(id).get();
        servicio.enable(objrol);
        return "redirect:/rol";
    }
    @GetMapping("/deshabilitarrol/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        RolEntity objrol = servicio.findById(id).get();
        servicio.delete(objrol);
        return "redirect:/rol";
    }
    
}

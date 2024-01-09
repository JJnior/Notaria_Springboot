
package pe.com.notaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.notaria.entity.RegistroEntity;
import pe.com.notaria.service.gestion.RegistroService;

@Controller
public class RegistroController {
    
     @Autowired
    private RegistroService servicio;
    
    @GetMapping("/registro")
    public String MostrarRegistro(Model modelo) {
        modelo.addAttribute("registros",
                servicio.findAllCustom());
        return "registro/registro";
    }
    @GetMapping("/registrarregistro")
    public String MostrarRegistrarRegistro() {
        return "registro/registrarregistro";
    }
    @ModelAttribute("registro")
    public RegistroEntity ModeloRegistro() {
        return new RegistroEntity();
    }
    @PostMapping("/registrarregistro")
    public String RegistrarRegistro(
            @ModelAttribute("registro") RegistroEntity f) {
        servicio.add(f);
        return "redirect:/registro";
    }
    @GetMapping("/actualizarregistro/{id}")
    public String MostrarActualizarRegistro(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("registros",
                servicio.findById(id).get());
        return "registro/actualizarregistro";
    }
    @PostMapping("/actualizarregistro/{id}")
    public String ActualizarRegistro(@PathVariable Long id,
            @ModelAttribute("registro") RegistroEntity f) {
        servicio.update(f);
        return "redirect:/registro";
    }
    
    @GetMapping("/eliminarregistro/{id}")
    public String EliminarRegistro(@PathVariable Long id) {
        RegistroEntity objregistro = servicio.findById(id).get();
        servicio.delete(objregistro);
        return "redirect:/registro";
    }
    
    @GetMapping("/habiltacionregistro")
    public String MostrarHabilitarRegistro(Model modelo) {
        modelo.addAttribute("registros",
                servicio.findAll());
        return "registro/habilitarregistro";
    }
    @GetMapping("/habilitarregistro/{id}")
    public String HabilitarRegistro(@PathVariable Long id) {
        RegistroEntity objregistro = servicio.findById(id).get();
        servicio.enable(objregistro);
        return "redirect:/registro";
    }
    @GetMapping("/deshabilitarregistro/{id}")
    public String DeshabilitarRegistro(@PathVariable Long id) {
        RegistroEntity objregistro = servicio.findById(id).get();
        servicio.delete(objregistro);
        return "redirect:/registro";
    }
}

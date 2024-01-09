
package pe.com.notaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.notaria.entity.ServicioEntity;
import pe.com.notaria.service.gestion.ServicioService;

@Controller
public class ServicioController {
    @Autowired
    private ServicioService servicio;
    @GetMapping("/servicio")
    public String MostrarServicio(Model modelo){
        modelo.addAttribute("servicios",
                servicio.findAllCustom());
        return "servicio/mostrarservicio";
    }
     @GetMapping("/registrarservicio")
    public String MostrarRegistrarServicio() {
        return "servicio/registrarservicio";
    }
    
    @ModelAttribute("servicio")
    public ServicioEntity Modeloservicio() {
        return new ServicioEntity();
    }
     @PostMapping("/registrarservicio")
    public String RegistrarServicio(
            @ModelAttribute("servicio") ServicioEntity s) {
        servicio.add(s);
        return "redirect:/servicio";
    }
    @GetMapping("/actualizarservicio/{id}")
    public String MostrarActualizarServicio(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("servicios",
                servicio.findById(id).get());
        return "servicio/actualizarservicio";
    }
    @PostMapping("/actualizarservicio/{id}")
    public String ActualizarServicio(@PathVariable Long id,
            @ModelAttribute("servicio") ServicioEntity s) {
        servicio.update(s);
        return "redirect:/servicio";
    }
    
    @GetMapping("/eliminarservicio/{id}")
    public String EliminarServicio(@PathVariable Long id) {
        ServicioEntity objservicio = servicio.findById(id).get();
        servicio.delete(objservicio);
        return "redirect:/servicio";
    }
    
    @GetMapping("/habiltacionservicio")
    public String MostrarHabilitarServicio(Model modelo) {
        modelo.addAttribute("servicios",
                servicio.findAll());
        return "servicio/habilitar";
    }
    @GetMapping("/habilitarservicio/{id}")
    public String HabilitarServicio(@PathVariable Long id) {
        ServicioEntity objservicio = servicio.findById(id).get();
        servicio.enable(objservicio);
        return "redirect:/servicio";
    }
    @GetMapping("/deshabilitarservicio/{id}")
    public String DeshabilitarServicio(@PathVariable Long id) {
        ServicioEntity objservicio = servicio.findById(id).get();
        servicio.delete(objservicio);
        return "redirect:/servicio";
    }
    
}



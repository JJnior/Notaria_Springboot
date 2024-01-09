package pe.com.notaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.notaria.service.seguridad.ClienteService;
import pe.com.notaria.entity.ClienteEntity;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService servicio;
    
    @GetMapping("/cliente")
    public String MostrarCliente(Model modelo) {
        modelo.addAttribute("clientes",
                servicio.findAllCustom());
        return "cliente";
    }
    
    @GetMapping("/registrarcliente")
    public String MostrarRegistrarCliente() {
        return "cliente/registrarcliente";
    }
    
    @ModelAttribute("cliente")
    public ClienteEntity ModelCliente(){
        return new ClienteEntity();
    }
    
    @PostMapping("/registrarcliente")
    public String RegistraCliente(
            @ModelAttribute ("cliente") ClienteEntity c){
        servicio.add(c);
        return "redirect:/cliente";
    }
    
    @GetMapping("/actualizarcliente/{id}")
    public String MostrarActualizarCliente(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("clientes",
                servicio.findById(id).get());
        return "cliente/actualizarcliente";
    }
    
    @PostMapping("/actualizarcliente/{id}")
    public String ActualizarCliente(@PathVariable Long id,
            @ModelAttribute("cliente") ClienteEntity c) {
        servicio.update(c);
        return "redirect:/cliente";
    }
    
    @GetMapping("/eliminarcliente/{id}")
    public String EliminarCliente(@PathVariable Long id) {
        ClienteEntity objcli = servicio.findById(id).get();
        servicio.delete(objcli);
        return "redirect:/cliente";
    }
    
    @GetMapping("/habilitacioncliente")
    public String MostrarHabilitarCliente(Model modelo) {
        modelo.addAttribute("clientes",
                servicio.findAll());
        return "cliente/habilitarcliente";
    }
    @GetMapping("/habilitarcliente/{id}")
    public String HabilitarCliente(@PathVariable Long id) {
        ClienteEntity objcli = servicio.findById(id).get();
        servicio.enable(objcli);
        return "redirect:/cliente";
    }
    @GetMapping("/deshabilitarcliente/{id}")
    public String DeshabilitarCliente(@PathVariable Long id) {
        ClienteEntity objcli = servicio.findById(id).get();
        servicio.delete(objcli);
        return "redirect:/cliente";
    }
    
}

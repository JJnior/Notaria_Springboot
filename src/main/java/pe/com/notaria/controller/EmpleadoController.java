package pe.com.notaria.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.notaria.entity.EmpleadoEntity;
import pe.com.notaria.service.seguridad.EmpleadoService;
import pe.com.notaria.service.seguridad.RolService;

@Controller
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService servicio;
    
    @Autowired
    private RolService servicioroles;

    @GetMapping("/empleado")
    public String MostrarEmpleado(Model modelo) {
        modelo.addAttribute("empleados",
                servicio.findAllCustom());
        return "empleado/mostrarempleado";
    }

    @GetMapping("/registrarempleado")
    public String MostrarRegistrarEmpleado(Model modelo) {
        modelo.addAttribute("roles",
                servicioroles.findAll());
        //mostrando la fecha y la hora actual
        LocalDateTime fechahoraactual=LocalDateTime.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaformateada=fechahoraactual.format(formato);
        modelo.addAttribute("fechahora",fechaformateada);
        return "empleado/registrarempleado";
    }

    @ModelAttribute("empleado")
    public EmpleadoEntity ModeloEmpleado() {
        return new EmpleadoEntity();
    }

//    @GetMapping("/cargarcomboprovincia/{id}")
//    public String CargaComboProvincia(@PathVariable String id,
//            Model modelo) {
//        modelo.addAttribute("provincias",
//                servicioprovincia.findbyDepartamento(id).get());
//        return "empleado/registrarempleado";
//    }
    @PostMapping("/registrarempleado")
    public String RegistrarEmpleado(
            @ModelAttribute("empleado") EmpleadoEntity e) {
        servicio.add(e);
        return "redirect:/empleado";
    }

    @GetMapping("/actualizarempleadop/{id}")
    public String MostrarActualizarEmppleado(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("empleados",
                servicio.findById(id).get());
        return "empleado/actualizarempleado";
    }

    @PostMapping("/actualizarempleado/{id}")
    public String ActualizarEmpleado(@PathVariable Long id,
            @ModelAttribute("empleado") EmpleadoEntity e) {
        servicio.update(e);
        return "redirect:/empleado";
    }

    @GetMapping("/eliminarempleado/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objempleado = servicio.findById(id).get();
        servicio.delete(objempleado);
        return "redirect:/empleado";
    }

    @GetMapping("/habiltacionempleado")
    public String MostrarHabilitarEmpleado(Model modelo) {
        modelo.addAttribute("empleados",
                servicio.findAll());
        return "rol/habilitarempleado";
    }

    @GetMapping("/habilitarempleado/{id}")
    public String HabilitarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objemplado = servicio.findById(id).get();
        servicio.enable(objemplado);
        return "redirect:/empleado";
    }

    @GetMapping("/deshabilitarempleado/{id}")
    public String DeshabilitarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objemplado = servicio.findById(id).get();
        servicio.delete(objemplado);
        return "redirect:/empleado";
    }
}

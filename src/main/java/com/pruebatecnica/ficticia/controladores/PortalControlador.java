package com.pruebatecnica.ficticia.controladores;

import com.pruebatecnica.ficticia.errores.ErrorServicio;
import com.pruebatecnica.ficticia.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String portada() {
        return "Index";
    }

    @PostMapping("/ingreso")
    public String login(ModelMap modelo, @RequestParam String mail, @RequestParam String clave) throws ErrorServicio {
        try {
            usuarioServicio.Ingresar(mail, clave);
        } catch (ErrorServicio ex) {
            modelo.put("error", ex.getMessage());
            return "login";
        }
        return "inicio";
    }

    @GetMapping("/iniciarsesion")
    public String inicio() {
        return "login";
    }

    @PostMapping("/portada")
    public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam long identificacion, @RequestParam String edad, @RequestParam String mail, @RequestParam String clave, @RequestParam String maneja, @RequestParam String genero, @RequestParam String usalentes, @RequestParam String diabetico, @RequestParam String otros) {
        try {
            usuarioServicio.registrar(nombre, clave, mail, identificacion, edad, genero, maneja, usalentes, diabetico, otros);
        } catch (ErrorServicio ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("identificacion", identificacion);
            modelo.put("edad", edad);
            modelo.put("otros", otros);
            modelo.put("mail", mail);
            modelo.put("clave", clave);

            return "Index";
        }

        return "exito";

    }
}

package com.pruebatecnica.ficticia.servicios;

import com.pruebatecnica.ficticia.entidades.Usuarios;
import com.pruebatecnica.ficticia.errores.ErrorServicio;
import com.pruebatecnica.ficticia.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrar(String nombre, String clave, String mail, long identificacion, String edad, String genero, String maneja, String usa_lentes, String diabetico, String otros) throws ErrorServicio {

        validar(nombre, clave, mail, identificacion, edad, genero, maneja, usa_lentes, diabetico, otros);

        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setMail(mail);
        usuario.setClave(clave);
        usuario.setIdentificacion(identificacion);
        usuario.setEdad(edad);
        usuario.setGenero(genero);
        usuario.setManeja(maneja);
        usuario.setDiabetico(diabetico);
        usuario.setUsa_lentes(usa_lentes);
        usuario.setOtros(otros);
        usuario.setAlta(new Date());

        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void Ingresar(String mail, String clave) throws ErrorServicio {
        Usuarios respuesta = usuarioRepositorio.buscarPorMail(mail);
        System.out.println(clave);
        if (respuesta != null) {
            if (respuesta.getClave().equals(clave)) {
            } else {
                throw new ErrorServicio("Contrasena incorrecta");
            }
        } else {
            throw new ErrorServicio("Usuario no registrado");
        }
    }

    private void validar(String nombre, String clave, String mail, long identificacion, String edad, String genero, String maneja, String usa_lentes, String diabetico, String otros) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El Nombre del Usuario no puede ser Nulo");
        }
        if (clave == null || clave.isEmpty() || clave.length() < 6) {
            throw new ErrorServicio("La Clave no puede ser nula o menor a 6 caracteres");
        }
        if (mail == null || mail.isEmpty()) {
            throw new ErrorServicio("Debe ingresar el Mail");
        }
        if (identificacion > 50000000 || identificacion < 20000000) {
            throw new ErrorServicio("Numero de DNI Invalido");
        }
        if (genero == null || genero.isEmpty()) {
            throw new ErrorServicio("Edad incorrecta");
        }
        if (edad == null) {
            throw new ErrorServicio("Edad incorrecta");
        }
        if (maneja == null || maneja.isEmpty()) {
            throw new ErrorServicio("Unos de los campos no fue especificado");
        }
        if (usa_lentes == null || usa_lentes.isEmpty()) {
            throw new ErrorServicio("Unos de los campos no fue especificado");
        }
        if (diabetico == null || diabetico.isEmpty()) {
            throw new ErrorServicio("Unos de los campos no fue especificado");
        }
        if (otros == null || otros.isEmpty()) {
            otros = null;
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

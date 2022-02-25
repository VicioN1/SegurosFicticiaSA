
package com.pruebatecnica.ficticia.repositorio;

import com.pruebatecnica.ficticia.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios,String>{
    
     @Query("SELECT c FROM Usuarios c WHERE c.mail = :mail")
     public Usuarios buscarPorMail(@Param("mail")String mail);   
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.notaria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.notaria.entity.ServicioEntity;

/**
 *
 * @author Usuario
 */
public interface ServicioRepository extends JpaRepository<ServicioEntity, Long>{

   
    @Query("select s from ServicioEntity s where s.estado=true")
    List<ServicioEntity> findAllCustom();
    
}

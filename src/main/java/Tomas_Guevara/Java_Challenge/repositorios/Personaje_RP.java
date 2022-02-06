/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tomas_Guevara.Java_Challenge.repositorios;

import Tomas_Guevara.Java_Challenge.entidades.Personaje;
import Tomas_Guevara.Java_Challenge.entidades.Production;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Tomás
 */
public interface Personaje_RP extends JpaRepository<Personaje, String> {

    @Query("SELECT a FROM Personaje a WHERE a.nombre = :nombre")
    public List<Personaje> findByName(@Param("nombre") String nombre);

    @Query("SELECT a FROM Personaje a WHERE a.edad >= :edad")
    public List<Personaje> filtroE(@Param("edad") Integer edad);
    
    @Query("SELECT a FROM Personaje a WHERE a.peso = :peso")
    public List<Personaje> filtroP(@Param("peso") Integer peso);

    @Query("SELECT a FROM Personaje a WHERE a.apariciones = :apariciones")
    public List<Personaje> filtroA(@Param("apariciones") Production apariciones);
}

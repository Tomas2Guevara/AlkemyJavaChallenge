/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tomas_Guevara.Java_Challenge.repositorios;

import Tomas_Guevara.Java_Challenge.entidades.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Tomás
 */
public interface Production_RP extends JpaRepository<Production, String> {

    @Query("SELECT a FROM Autor a WHERE a.titulo = :titulo")
    public Production findByName(@Param("titulo") String titulo);
    
}

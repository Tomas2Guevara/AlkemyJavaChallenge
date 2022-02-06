/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tomas_Guevara.Java_Challenge.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Tomás
 */
@Entity
public class Genero implements Serializable{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    
    private String nombre;
    
    @OneToMany
    private Production perliculas;

    public Genero() {
    }

    public Genero(String id, String nombre, Production perliculas) {
        this.id = id;
        this.nombre = nombre;
        this.perliculas = perliculas;
    }
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the perliculas
     */
    public Production getPerliculas() {
        return perliculas;
    }

    /**
     * @param perliculas the perliculas to set
     */
    public void setPerliculas(Production perliculas) {
        this.perliculas = perliculas;
    }

    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nombre=" + nombre + ", perliculas=" + perliculas + '}';
    }   
    
    
}

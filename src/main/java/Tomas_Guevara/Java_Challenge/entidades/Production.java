/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tomas_Guevara.Java_Challenge.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Tomás
 */
@Entity
public class Production implements Serializable{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    
    private String titulo;
    
    @Temporal(TemporalType.DATE)
    private Date lanzamiento; 
    
    private Integer calificacion;
    
    @ManyToOne
    private Personaje personajes;

    public Production() {
    }

    public Production(String id, String titulo, Date lanzamiento, Integer calificacion, Personaje personajes) {
        this.id = id;
        this.titulo = titulo;
        this.lanzamiento = lanzamiento;
        this.calificacion = calificacion;
        this.personajes = personajes;
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the lanzamiento
     */
    public Date getLanzamiento() {
        return lanzamiento;
    }

    /**
     * @param lanzamiento the lanzamiento to set
     */
    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the personajes
     */
    public Personaje getPersonajes() {
        return personajes;
    }

    /**
     * @param personajes the personajes to set
     */
    public void setPersonajes(Personaje personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return "Producction{" + "id=" + id + ", titulo=" + titulo + ", lanzamiento=" + lanzamiento + ", calificacion=" + calificacion + ", personajes=" + personajes + '}';
    }
    
    
    
    
    
}

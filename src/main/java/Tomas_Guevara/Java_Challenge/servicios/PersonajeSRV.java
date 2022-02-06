/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tomas_Guevara.Java_Challenge.servicios;

import Tomas_Guevara.Java_Challenge.entidades.Personaje;
import Tomas_Guevara.Java_Challenge.entidades.Production;
import Tomas_Guevara.Java_Challenge.repositorios.Personaje_RP;
import Tomas_Guevara.Java_Challenge.repositorios.Production_RP;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tomás
 */
public class PersonajeSRV {

    @Autowired
    private Personaje_RP pr;

    @Autowired
    private Production_RP pdr;

    @Transactional
    public void nuevo(String nombre, Integer edad, Integer peso, String historia, String ID_ap) throws Exception {
        validar(nombre, edad, peso, historia, ID_ap);

        Personaje p = new Personaje(nombre, nombre, edad, peso, historia, pdr.findById(ID_ap).get());
        pr.save(p);
    }

    @Transactional
    public void modificar(String id, String nombre, Integer edad, Integer peso, String historia, String ID_ap) throws Exception {
        Optional<Personaje> ansP = pr.findById(id);

        if (ansP.isPresent()) {

            validar(nombre, edad, peso, historia, ID_ap);
            Personaje p = ansP.get();
            p.setNombre(nombre);
            p.setEdad(edad);
            p.setPeso(peso);
            p.setHistoria(historia);
            pr.save(p);
        }

    }

    @Transactional
    public void eliminar(String id) throws Exception {
        Optional<Personaje> ans = pr.findById(id);
        if (ans.isPresent()) {
            pr.delete(ans.get());
        } else {
            throw new Exception("Debe ingresar un nombre una película existente");
        }
    }

    @Transactional
    public List<Personaje> todos() {
        return pr.findAll();
    }

    @Transactional
    public Personaje detalle(String id) throws Exception {
        Optional<Personaje> ans = pr.findById(id);
        if (ans.isPresent()) {
            return ans.get();
        } else {
            throw new Exception("Debe ingresar un nombre una película existente");
        }
    }

    @Transactional
    public List<Personaje> nombre(String n) {
        List p = pr.findByName(n);
        return p;
    }

    @Transactional
    public List<Personaje> filtarE(Integer e) {
        return pr.filtroE(e);
    }
    
    @Transactional
    public List<Personaje> filtarP(Integer e) {
        return pr.filtroE(e);
    }

    @Transactional
    public List<Personaje> filtarA(String Id_A) throws Exception {
        Optional<Production> ansP = pdr.findById(Id_A);
        if (ansP.isPresent()) {
            return pr.filtroA(ansP.get());
        } else {
            throw new Exception("No se encontró la producción");
        }
    }

    public void validar(String nombre, Integer edad, Integer peso, String historia, String ID_ap) throws Exception {
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("Nombre del personaje inválido");
        }

        if (edad == null || edad < 0) {
            throw new Exception("Edad del personaje inválido");
        }

        if (peso == null || peso <= 0) {
            throw new Exception("Peso del personaje inválido");
        }

        if (historia == null || historia.isEmpty()) {
            throw new Exception("Historia del personaje inválido");
        }
        Optional<Production> ansP = pdr.findById(ID_ap);
        if (ID_ap == null || ID_ap.isEmpty() || !ansP.isPresent()) {
            throw new Exception("Apariciones del personaje inválidas");
        }

    }

}

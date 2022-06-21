/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author pc
 */
public class Materia implements Entidad {
    private Integer id;
    private String materia;

    public Materia(Integer id, String materia) {
        this.id = id;
        this.materia = materia;
    }

    public Materia(String materia) {
        this.materia = materia;
    }

  

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public Integer getId() {
        return id;
    }


    
}

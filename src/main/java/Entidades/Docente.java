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
public class Docente {
    
    private Integer id;
    private Usuario usuario;
    private Materia materia;
    private String nombre;
    private String apellido;

    public Docente(Integer idDocente, Usuario idUsuario, Materia idMateria, String nombre, String apellido) {
        this.id = idDocente;
        this.usuario = idUsuario;
        this.materia = idMateria;
        this.nombre = nombre;
        this.apellido = apellido;
    }



    public Docente(Usuario idUsuario, Materia idMateria, String nombre, String apellido) {
        this.usuario = idUsuario;
        this.materia = idMateria;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Docente(String na) {
      this.nombre = na;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}

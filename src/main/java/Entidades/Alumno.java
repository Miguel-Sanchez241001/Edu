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
public class Alumno implements   Entidad {

    private Integer idAlumnos;
    private Docente idDocente;
    private Usuario idUser;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Alumno(String na) {
        this.nombre = na;
    }

    public Integer getIdAlumnos() {
        return idAlumnos;
    }

    public void setIdAlumnos(Integer idAlumnos) {
        this.idAlumnos = idAlumnos;
    }

    public Docente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docente idDocente) {
        this.idDocente = idDocente;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Alumno(Docente idDocente, Usuario idUser, String nombre, String apellido, Integer edad) {
        this.idDocente = idDocente;
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Alumno(Integer idAlumnos, Docente idDocente, Usuario idUser, String nombre, String apellido, Integer edad) {
        this.idAlumnos = idAlumnos;
        this.idDocente = idDocente;
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

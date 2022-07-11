/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.InputStream;

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
    private String Correo;

    public Docente(Integer id, Usuario usuario, Materia materia, String nombre, String apellido, String Correo, String Estudios) {
        this.id = id;
        this.usuario = usuario;
        this.materia = materia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.Estudios = Estudios;
    }
    private String Estudios;
    private InputStream imgsave;
    private byte[] imgshow;

    public Docente(Integer id, Usuario usuario, Materia materia, String nombre, String apellido, String Correo, String Estudios, InputStream imgsave, byte[] imgshow) {
        this.id = id;
        this.usuario = usuario;
        this.materia = materia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.Estudios = Estudios;
        this.imgsave = imgsave;
        this.imgshow = imgshow;
    }

    public Docente(Usuario usuario, Materia materia, String nombre, String apellido, String Correo, String Estudios, InputStream imgsave) {
        this.usuario = usuario;
        this.materia = materia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.Estudios = Estudios;
        this.imgsave = imgsave;
    }

    public Docente(Usuario usuario, Materia materia, String nombre, String apellido, String Correo, String Estudios, InputStream imgsave, byte[] imgshow) {
        this.usuario = usuario;
        this.materia = materia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.Estudios = Estudios;
        this.imgsave = imgsave;
        this.imgshow = imgshow;
    }

    public Docente(Integer id, Usuario usuario, Materia materia, String nombre, String apellido) {
        this.id = id;
        this.usuario = usuario;
        this.materia = materia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Docente(Usuario usuario, Materia materia, String nombre, String apellido, String Correo, String Estudios) {
        this.usuario = usuario;
        this.materia = materia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.Estudios = Estudios;
    }

  

    public Docente(String na) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getEstudios() {
        return Estudios;
    }

    public void setEstudios(String Estudios) {
        this.Estudios = Estudios;
    }

    public InputStream getImgsave() {
        return imgsave;
    }

    public void setImgsave(InputStream imgsave) {
        this.imgsave = imgsave;
    }

    public byte[] getImgshow() {
        return imgshow;
    }

    public void setImgshow(byte[] imgshow) {
        this.imgshow = imgshow;
    }

}

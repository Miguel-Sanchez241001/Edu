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
public class Usuario {
    private Integer id;
    private String username;
    private String clave;
    private Integer tipo;

    public Usuario(Integer id, String username, String clave, Integer tipo) {
        this.id = id;
        this.username = username;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario(String username, String clave, Integer tipo) {
        this.username = username;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
}

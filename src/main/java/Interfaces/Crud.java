/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Entidades.Alumno;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Nota;
import Entidades.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface Crud {

    // listar 
    public List listar(); 



  // eliminar
    public void deleteId( Integer id );
}

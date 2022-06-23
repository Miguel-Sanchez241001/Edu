/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Dao.AlumnoDao;
import Dao.DocenteDao;
import Dao.MateriaDao;
import Dao.NotaDao;
import Dao.UsuarioDao;
import Entidades.Entidad;
import java.util.List;

/**
 *
 * @author pc
 */
public class Fabrica {

     UsuarioDao usuariodao = new UsuarioDao();
     MateriaDao materiaDao = new MateriaDao();
     DocenteDao docenteDao = new DocenteDao();
     AlumnoDao alumnoDao = new AlumnoDao();
     NotaDao notaDao = new NotaDao();
     


    public  List<Entidad> getLista(String Tipo) {
        
        if (Tipo.equals("Materia")) {
            return materiaDao.listar();
        }
        if (Tipo.equals("Nota")) {
            return notaDao.listar();
        }
        if (Tipo.equals("Docente")) {
            return docenteDao.listar();
        }
        if (Tipo.equals("Alumno")) {
            return alumnoDao.listar();
        } 
     
            return usuariodao.listar();
      
    }

}

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

    static UsuarioDao usuariodao = new UsuarioDao();
    static MateriaDao materiaDao = new MateriaDao();
    static DocenteDao docenteDao = new DocenteDao();
    static AlumnoDao alumnoDao = new AlumnoDao();
    static NotaDao notaDao = new NotaDao();
    static Fabrica fab = new Fabrica();

    private Fabrica() {
    }

    public static List<Entidad> getLista(String Tipo) {
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
        } else {
            return usuariodao.listar();
        }

    }

}

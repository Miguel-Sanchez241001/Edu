/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.edutin.edutinservicio;

import Interfaces.Fabrica;
import Dao.AlumnoDao;
import Dao.DocenteDao;
import Dao.MateriaDao;
import Dao.NotaDao;
import Dao.UsuarioDao;
import Dao.chatDao;
import Entidades.Alumno;
import Entidades.Chat;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Nota;
import Entidades.Usuario;
import java.util.List;
import java.util.Optional;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author pc
 */
@WebService(serviceName = "ServiciosEdutin")
public class ServiciosEdutin {


    UsuarioDao usuariodao = new UsuarioDao();
    MateriaDao materiaDao = new MateriaDao();
    DocenteDao docenteDao = new DocenteDao();
    AlumnoDao alumnoDao = new AlumnoDao();
    NotaDao notaDao = new NotaDao();
    

    @WebMethod(operationName = "ListarFabrica")
    public List<?> ListarFabrica(@WebParam(name = "Nota") String Tipo) {
        return Fabrica.getLista(Tipo);
    }

//     ------------LISTAR---------------------- 
    @WebMethod(operationName = "Listar")
    public List<Usuario> Listar() {
        return usuariodao.listar();
    }
    @WebMethod(operationName = "ListarMaterias")
    public List<Materia> ListarMaterias() {
        return materiaDao.listar();
    }

    @WebMethod(operationName = "ListarDocentes")
    public List<Docente> ListarDocentes() {
        return docenteDao.listar();
    }

    @WebMethod(operationName = "ListarAlumnos")
    public List<Alumno> ListarAlumnos() {
        return alumnoDao.listar();
    }

    @WebMethod(operationName = "ListarNotas")
    public List<Nota> ListarNotas() {
        return notaDao.listar();
    }

    //------------REGISTRAR---------------------- 
    /**
     * Web service operation
     *
     * @param UserName
     * @param Clave
     * @param Tipo
     * @return
     */
    
    @WebMethod(operationName = "Registrar")
    public String Registrar(@WebParam(name = "UserName") String UserName, @WebParam(name = "Clave") String Clave, @WebParam(name = "Tipo") int Tipo) {
        Usuario usuario = new Usuario(UserName, Clave, Tipo);
        return usuariodao.insert(usuario);
    }

    @WebMethod(operationName = "RegistrarMateria")
    public String RegistrarMateria(@WebParam(name = "Materia") String Materia) {
        Materia materia = new Materia(Materia);
        return materiaDao.insert(materia);
    }

    @WebMethod(operationName = "RegistrarDocente")
    public String RegistrarDocente(@WebParam(name = "Usuario") int idusuario, @WebParam(name = "Materia") int idMateria, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido) {
        Usuario usuario = usuariodao.findId(idusuario).get();
        Materia materia = materiaDao.findId(idMateria).get();
        Docente docente = new Docente(usuario, materia, nombre, apellido);
        return docenteDao.insert(docente);
    }

    @WebMethod(operationName = "RegistrarAlumno")
    public String RegistrarAlumno(@WebParam(name = "Docente") int idDocente, @WebParam(name = "Nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "Edad") Integer edad, @WebParam(name = "Usuario") int idusuario) {
        Docente docente = docenteDao.findId(idDocente).get();
        Usuario usuario = usuariodao.findId(idusuario).get();

        Alumno alumno = new Alumno(docente, usuario, nombre, apellido, edad);
        return alumnoDao.insert(alumno);
    }

    @WebMethod(operationName = "RegistrarNota")
    public String RegistrarNota(@WebParam(name = "Materia") int idmateria, @WebParam(name = "Alumno") int idalumno, @WebParam(name = "nota") double puntaje) {
        Materia materia = materiaDao.findId(idmateria).get();
        Alumno alumno = alumnoDao.findId(idalumno).get();

        Nota nota = new Nota(materia, alumno, puntaje);
        return notaDao.insert(nota);
    }

    /**
     * Web service operation
     *
     * @param UserName
     * @return
     */
    //-----LOGUEAR--USUARIO------
    @WebMethod(operationName = "Loguear")
    public Usuario Loguear(@WebParam(name = "UserName") String UserName) {
        Usuario usuario;
        Optional<Usuario> optionalUsuario = usuariodao.loguear(UserName);
        if (optionalUsuario.isPresent()) {
            usuario = optionalUsuario.get();

        } else {
            usuario = new Usuario("na", "na", 0);
        }
        return usuario;
    }

    //-----BUSCAR------
    @WebMethod(operationName = "BuscarMateria")
    public Materia BuscarMateria(@WebParam(name = "idMateria") Integer idMateria) {
        Materia materia;
        Optional<Materia> optionalMateria = materiaDao.findId(idMateria);
        if (optionalMateria.isPresent()) {
            materia = optionalMateria.get();

        } else {
            materia = new Materia(0, "na");
        }
        return materia;
    }

    @WebMethod(operationName = "BuscarDocente")
    public Docente BuscarDocente(@WebParam(name = "idDocente") String idDocente) {
        Docente docente;
        Optional<Docente> optionalDocente = docenteDao.findName(idDocente);
        if (optionalDocente.isPresent()) {
            docente = optionalDocente.get();

        } else {
            docente = new Docente("na");
        }
        return docente;
    }

    @WebMethod(operationName = "BuscarAlumno")
    public Alumno BuscarAlumno(@WebParam(name = "idAlumno") String idAlumno) {
        Alumno alumno;
        Optional<Alumno> optionalAlumno = alumnoDao.findNombre(idAlumno);
        if (optionalAlumno.isPresent()) {
            alumno = optionalAlumno.get();

        } else {
            alumno = new Alumno("na");
        }
        return alumno;
    }

    @WebMethod(operationName = "BuscarNota")
    public Nota BuscarNota(@WebParam(name = "idNota") Integer idNota) {
        Nota nota;
        Optional<Nota> optionalNota = notaDao.findId(idNota);
        if (optionalNota.isPresent()) {
            nota = optionalNota.get();

        } else {
            nota = new Nota(0);
        }
        return nota;
    }

    //---------AGREGAR MENSAJE
    @WebMethod(operationName = "RegistrarMensaje")
    public String RegistrarMensaje(@WebParam(name = "nombre") String nombre, @WebParam(name = "mensaje") String mensaje, @WebParam(name = "Destinatario") String Destinatario) {
        chatDao dao = new chatDao();
        Chat chat = new Chat(nombre, mensaje, Destinatario);
        String res = "Error";
        try {
            res = dao.agregarMensaje(chat);

        } catch (Exception e) {
            System.err.println(e);
        }
        return res;
    }

}

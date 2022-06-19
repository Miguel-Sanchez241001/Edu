/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entidades.Alumno;
import Entidades.Docente;
import Entidades.Usuario;
import Interfaces.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public class AlumnoDao implements Crud {

    public final Connection conn;
    private PreparedStatement ps;
    private static DocenteDao docenteDao;
    private static UsuarioDao usuarioDao;

    public AlumnoDao() {
        conn = Conexion.openConnection();
        docenteDao = new DocenteDao();
        usuarioDao = new UsuarioDao();
    }

    public String insert(Alumno alumno) {
        String men;
        try {
            String sql = "INSERT INTO alumnos (idDocente,nombre,apellido,edad,idUser) "
                    + "VALUES (?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, alumno.getIdDocente().getId());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setInt(4, alumno.getEdad());
            ps.setInt(5, alumno.getIdUser().getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("se logro insertar el Alumno");
        } catch (Exception e) {
            System.out.println("Problema aqui");
            System.err.println(e.getMessage());
        }

        Optional<Alumno> test = findNombre(alumno.getNombre());
        if (test.isPresent()) {
            men = "Se inserto alumno con exito";
        } else {
            men = "Problemas";

        }

        return men;
    }

    @Override
    public List listar() {
        ArrayList<Alumno> list = new ArrayList<>();
        String sql = "SELECT * FROM  alumnos";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idUser");
                int idDocente = rs.getInt("idDocente");

                Optional<Docente> optionalDocente = docenteDao.findId(idDocente);
                Optional<Usuario> optionalUsuario = usuarioDao.findId(idUsuario);

                Alumno alumno = new Alumno(optionalDocente.get(), optionalUsuario.get(), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
                list.add(alumno);
            }
            System.out.println("se logro listar Alumnos");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public Optional<Alumno> findId(Integer ID) {
        Optional<Alumno> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  alumnos WHERE idAlumnos = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idUsuario = rs.getInt("idUser");
                int idDocente = rs.getInt("idDocente");

                Optional<Docente> optionalDocente = docenteDao.findId(idDocente);
                Optional<Usuario> optionalUsuario = usuarioDao.findId(idUsuario);
                Alumno alumno = new Alumno(rs.getInt("idAlumnos"),optionalDocente.get(), optionalUsuario.get(), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
                optional = Optional.of(alumno);
            }
            ps.close();
            rs.close();
            System.out.println("Se encontro Alumno" + rs.getString("nombre"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public Optional<Alumno> findNombre(String nombre) {
        Optional<Alumno> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  alumnos WHERE nombre = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idUsuario = rs.getInt("idUser");
                int idDocente = rs.getInt("idDocente");

                Optional<Docente> optionalDocente = docenteDao.findId(idDocente);
                Optional<Usuario> optionalUsuario = usuarioDao.findId(idUsuario);
                Alumno alumno = new Alumno(rs.getInt("idAlumnos"),optionalDocente.get(), optionalUsuario.get(), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
                optional = Optional.of(alumno);
                System.out.println("Se encontro Alumno " + rs.getString("nombre"));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    @Override
    public void deleteId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        AlumnoDao a = new AlumnoDao();
        Conexion con = new Conexion();
        System.out.println(a.conn);
        System.out.println(con.conn);
        
    }

}

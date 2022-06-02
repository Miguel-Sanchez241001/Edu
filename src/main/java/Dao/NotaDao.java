/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entidades.Alumno;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Nota;
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
public class NotaDao implements Crud {

    private final Connection conn;
    private PreparedStatement ps;
    private AlumnoDao alumnoDao;
    private MateriaDao materiaDao;

    public NotaDao() {
        conn = Conexion.openConnection();
        alumnoDao = new AlumnoDao();
        materiaDao = new MateriaDao();
    }

    public String insert(Nota nota) {

        try {
            String sql = "INSERT INTO notas (idCurso,idAlumno,nota) "
                    + "VALUES (?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, nota.getIdCurso().getId());
            ps.setInt(2, nota.getAlumno().getIdAlumnos());
            ps.setDouble(3, nota.getNota());
            ps.executeUpdate();
            ps.close();
            System.out.println("se logro insertar la nota de " + nota.getAlumno().getNombre());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "se agrego nota de " + nota.getIdCurso().getMateria();
    }

    @Override
    public List listar() {
        ArrayList<Nota> list = new ArrayList<>();
        String sql = "SELECT * FROM  notas";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int idCurso = rs.getInt("idCurso");
                int idAlumno = rs.getInt("idAlumno");
                Optional<Alumno> optionalAlumno = alumnoDao.findId(idAlumno);
                Optional<Materia> optionalMateria = materiaDao.findId(idCurso);

                Nota nota = new Nota(rs.getInt("idNotas"), optionalMateria.get(), optionalAlumno.get(), rs.getDouble("nota"));
                list.add(nota);
            }
            System.out.println("se logro listar notas");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public Optional<Nota> findId(Integer ID) {
        Optional<Nota> optional = Optional.empty();
        Alumno alumNota = null;
        try {
            String sql = "SELECT * FROM  notas WHERE idNotas = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int idCurso = rs.getInt("idCurso");
                int idAlumno = rs.getInt("idAlumno");
                Optional<Alumno> optionalAlumno = alumnoDao.findId(idAlumno);
                Optional<Materia> optionalMateria = materiaDao.findId(idCurso);

                Nota nota = new Nota(rs.getInt("idNotas"), optionalMateria.get(), optionalAlumno.get(), rs.getDouble("nota"));
                optional = Optional.of(nota);
                alumNota = (Alumno) optionalAlumno.get();
                System.out.println("se logro encontrar nota de " + alumNota.getNombre());
            } else {
                System.out.println("No se logro encontrar la nota");
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Usuario;
import Interfaces.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public class DocenteDao implements Crud {

    private final Connection conn;
    private PreparedStatement ps;
    private final UsuarioDao usuarioDao;
    private final MateriaDao materiaDao;

    public DocenteDao() {
        conn = Conexion.openConnection();
        usuarioDao = new UsuarioDao();
        materiaDao = new MateriaDao();
    }

    public String insert(Docente docente) {

        try {
            String sql = "INSERT INTO docentes (idUsuario,idMateria,nombre,apellido) "
                    + "VALUES (?, ?, ?,?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, docente.getUsuario().getId());
            ps.setInt(2, docente.getMateria().getId());
            ps.setString(3, docente.getNombre());
            ps.setString(4, docente.getApellido());

            ps.executeUpdate();
            ps.close();
            System.out.println("se logro insertar el docente");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "se agrego " + docente.getNombre();
    }

    @Override
    public List listar() {
        ArrayList<Docente> list = new ArrayList<>();
        String sql = "SELECT * FROM  docentes";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                int idMateria = rs.getInt("idMateria");
                Optional<Usuario> optionalUsuario = usuarioDao.findId(idUsuario);
                Optional<Materia> optionalMateria = materiaDao.findId(idMateria);
                Docente docente = new Docente(rs.getInt("idDocentes"), optionalUsuario.get(), optionalMateria.get(), rs.getString("nombre"), rs.getString("apellido"));
                list.add(docente);
            }
            System.out.println("se logro listar docentes");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public Optional<Docente> findName(String ID) {
        Optional<Docente> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  docentes WHERE nombre = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                int idMateria = rs.getInt("idMateria");
                Optional<Usuario> optionalUsuario = usuarioDao.findId(idUsuario);
                Optional<Materia> optionalMateria = materiaDao.findId(idMateria);
                Docente docente = new Docente(rs.getInt("idDocentes"), optionalUsuario.get(), optionalMateria.get(), rs.getString("nombre"), rs.getString("apellido"));

                optional = Optional.of(docente);
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

    }

   public Optional<Docente> findId(int idDocente) {
          Optional<Docente> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  docentes WHERE idDocentes = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idDocente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                int idMateria = rs.getInt("idMateria");
                Optional<Usuario> optionalUsuario = usuarioDao.findId(idUsuario);
                Optional<Materia> optionalMateria = materiaDao.findId(idMateria);
                Docente docente = new Docente(rs.getInt("idDocentes"), optionalUsuario.get(), optionalMateria.get(), rs.getString("nombre"), rs.getString("apellido"));

                optional = Optional.of(docente);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional; }

}

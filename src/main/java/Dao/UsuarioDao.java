/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entidades.Usuario;
import Interfaces.Crud;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class UsuarioDao implements Crud {

    private final Connection conn;
    private PreparedStatement ps;

    public UsuarioDao() {
        conn = Conexion.openConnection();
    }

    public String insert(Usuario usuario) {

        try {
            String sql = "INSERT INTO usuarios (username,clave,tipo) "
                    + "VALUES (?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getClave());
            ps.setInt(3, usuario.getTipo());
            ps.executeUpdate();
            ps.close();
            System.out.println("se logro insertar");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "se agrego " + usuario.getUsername();
    }

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM  usuarios";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("clave"), rs.getInt("tipo"));
                list.add(usuario);
            }
            System.out.println("se logro listar");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public Optional loguear(String username) {
        Optional<Usuario> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  usuarios WHERE username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("clave"), rs.getInt("tipo"));

                optional = Optional.of(usuario);
            }
            ps.close();
            rs.close();
            System.out.println("se logro ejecutar la busqueda");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public Optional<Usuario> findId(Integer ID) {
        Optional<Usuario> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  usuarios WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario Turno = new Usuario(rs.getInt("id"), rs.getString("username"),rs.getString("clave"),rs.getInt("tipo"));

                optional = Optional.of(Turno);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update(Usuario usuario) {
        try {
            String sql = "UPDATE usuarios SET username = ?, clave = ?,tipo = ? "
                    + "WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getClave());
            ps.setInt(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("se actualizo");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteId(Integer id) {
        try {
            String sql = "DELETE FROM usuario WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            System.out.println("se logro eliminar el usuario");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

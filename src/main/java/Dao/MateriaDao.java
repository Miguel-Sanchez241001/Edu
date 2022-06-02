/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entidades.Materia;
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
public class MateriaDao implements Crud {

    private final Connection conn;
    private PreparedStatement ps;

    public MateriaDao() {
        conn = Conexion.openConnection();
    }

    public String insert(Materia materia) {

        try {
            String sql = "INSERT INTO materias (materia) "
                    + "VALUES (?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, materia.getMateria());
            ps.executeUpdate();
            ps.close();
            System.out.println("se logro insertar la materia");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "se agrego " + materia.getMateria();
    }

    @Override
    public List listar() {
        ArrayList<Materia> list = new ArrayList<>();
        String sql = "SELECT * FROM  materias";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia(rs.getInt("idMaterias"), rs.getString("materia"));
                list.add(materia);
            }
            System.out.println("se logro listar las materias");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
   public Optional<Materia> findId(Integer ID) {
        Optional<Materia> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  materias WHERE idMaterias = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Materia Turno =new Materia(rs.getInt("idMaterias"),rs.getString("materia"));

                optional = Optional.of(Turno);
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

}

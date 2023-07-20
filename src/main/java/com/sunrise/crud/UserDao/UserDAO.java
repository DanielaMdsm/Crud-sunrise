/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sunrise.crud.UserDao;

import com.sunrise.crud.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author danie
 */
public class UserDAO implements DAO {

   private final String GET_ALL= "SELECT * FROM users"; 
   private final String GET_USER= "SELECT * FROM users WHERE id=?";
   private final String INSERT_USER= "INSERT INTO users (name,last_name,email,consultation) VALUES (?,?,?,?)";
   private final String UPDATE_USER= "UPDATE users SET name=?,last_name=?,email=?,consultation=? WHERE id=?";
   private final String REMOVE_USER= "DELETE FROM users WHERE id=?";
    @Override
    public List<User> getUsers(){
         List<User> users = new ArrayList<>();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String consultation = rs.getString("consultation");
                users.add(new User(id, name, lastName, email, consultation));
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al consultar usuarios", ex);
        }

        return users;
    }
    

    @Override
    public User getUser(int id) {
       User user = null;
       try {
           
           Connection con= Conexion.getConnection();
           PreparedStatement ps= con.prepareStatement(GET_USER);
           ps.setInt(1, id);
           ResultSet rs= ps.executeQuery();
           
           if(rs.next()){
               String name= rs.getString("name");
               String lastName= rs.getString("last_name");
               String email= rs.getString("email");
               String consultation= rs.getString("consultation");
               user= new User(id, name, lastName, email, consultation);
               return user;
           }
       } catch (SQLException ex) {
            throw new RuntimeException("Error al consultar usuario",ex);
       }
       return user;
     
    }
    
    

    @Override
    public void addUser(User user) {
       try(Connection con= Conexion.getConnection();
           PreparedStatement ps= con.prepareStatement(INSERT_USER)) {
           
           ps.setString(1, user.getName());
           ps.setString(2, user.getLastName());
           ps.setString(3, user.getEmail());
           ps.setString(4, user.getConsultation());
           
           ps.executeUpdate();
       } catch (SQLException ex) {
            throw new RuntimeException("Error al agregar usuario",ex);
       }
    }

    @Override
    public void updateUser(User user) {
         try(Connection con= Conexion.getConnection();
           PreparedStatement ps= con.prepareStatement(UPDATE_USER)) {
           
           ps.setString(1, user.getName());
           ps.setString(2, user.getLastName());
           ps.setString(3, user.getEmail());
           ps.setString(4, user.getConsultation());
           ps.setInt(5, user.getId());
           
           ps.executeUpdate();
       } catch (SQLException ex) {
            throw new RuntimeException("Error al modificar usuario",ex);
       }
    }

    @Override
    public void removeUser(int id) {
       try(Connection con= Conexion.getConnection();
           PreparedStatement ps= con.prepareStatement(REMOVE_USER)){
           
           ps.setInt(1,id);
           ps.executeUpdate();
       } catch (SQLException ex) {
           throw new RuntimeException("Error al eliminar usuario",ex);
       }
    }
    
}

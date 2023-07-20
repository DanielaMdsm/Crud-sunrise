/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sunrise.crud.UserDao;

import com.sunrise.crud.entity.User;
import java.util.List;

/**
 *
 * @author danie
 */
public interface DAO {
    
    public List<User> getUsers();
    public User getUser(int id);
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    
}

package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    @Override
    public List<User> getAllUser() throws Exception {
        List<User> result = new ArrayList<>();
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("select * from user");
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");

           result.add(new User(id, name, surname, phone, email));
        }


        con.close();
        return result;
    }

    public User getById(int userId) throws Exception {
        User result = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("select * from user where id=" + userId);
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");

            result = new User(id, name, surname, phone, email);
        }


        con.close();
        return result;
    }

    @Override
    public boolean updateUser(User u) throws Exception {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("update user set name=?, surname=?, phone=?, email=? where id=?");
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getSurname());
        stmt.setString(3, u.getPhone());
        stmt.setString(4, u.getEmail());
        stmt.setInt(5,u.getId());
        return stmt.execute();
    }

    @Override
    public boolean removeUser(int id) throws Exception {
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("delete user from where id = 2");
        return true;
    }





}

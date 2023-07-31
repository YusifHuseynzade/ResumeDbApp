package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    @Override
    public boolean updateUser(User u) throws Exception {
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("update user set name = 'Sarkhan' where id = 1");
        return true;
    }

    @Override
    public boolean removeUser(int id) throws Exception {
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("delete user from where id = 2");
        return true;
    }





}

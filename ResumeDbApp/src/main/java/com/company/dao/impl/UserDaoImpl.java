package com.company.dao.impl;

import com.company.entity.Nationality;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        Date birthDate = rs.getDate("birth_date");
        String nationalityStr = rs.getString("nationality");
        int nationalityId = rs.getInt("nationality_id");

        Nationality nationality = new Nationality(nationalityId, nationalityStr);

        return new User(id, name, surname, phone, email, birthDate, nationality);
    }
    @Override
    public List<User> getAllUser() throws Exception {
        List<User> result = new ArrayList<>();
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("SELECT"
                + " u.*, "
                + " n.name AS nationality "
                + " FROM user u "
                + " LEFT JOIN nationality n ON u.nationality_id = n.id ");
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            User usr = getUser(rs);

           result.add(usr);
        }
        con.close();
        return result;
    }

    public User getById(int userId) throws Exception {
        User result = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("SELECT"
                + " u.*, "
                + " n.name AS nationality "
                + " FROM user u "
                + " LEFT JOIN nationality n ON u.nationality_id = n.id where u.id=" + userId);
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            result = getUser(rs);
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
    public boolean addUser(User u) throws Exception {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("insert into user(name, surname, phone, email) value(?,?,?,?)");
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getSurname());
        stmt.setString(3, u.getPhone());
        stmt.setString(4, u.getEmail());
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

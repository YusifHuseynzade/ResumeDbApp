package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter{
    @Override
    public List<Skill> getAll() throws Exception {
        List<Skill> result = new ArrayList<>();
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.execute("SELECT * FROM skill");
        ResultSet rs = stmt.getResultSet();

        while (rs.next()) {

            int id = rs.getInt("Id");
            String name = rs.getString("name");
            result.add(new Skill(id, name));

        }
        return result;
    }

    @Override
    public Skill getById(int userId) throws Exception {
        Skill result = null;
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM skill WHERE ID = ?");
        stmt.setInt(1, userId);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();

        while (rs.next()) {

            int id = rs.getInt("Id");
            String name = rs.getString("name");

            result = new Skill(id, name);

        }
        return result;
    }

    @Override
    public boolean updateSkill(Skill u) throws Exception {
        Connection con = connect();
        boolean b = true;
        PreparedStatement stmt = con.prepareStatement("UPDATE skill SET name=? WHERE id= ?");
        stmt.setString(1, u.getName());
        stmt.setInt(2, u.getId());
        b = stmt.execute();

        return b;
    }

    public boolean insertSkill(Skill skl) throws Exception {
        Connection con = connect();
        boolean b = true;
        PreparedStatement stmt = con.prepareStatement("insert skill (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, skl.getName());
        b = stmt.execute();

        ResultSet generatedKeys = stmt.getGeneratedKeys();

        if (generatedKeys.next()) {
            skl.setId(generatedKeys.getInt(1));
        }
        return b;
    }

    @Override
    public boolean removeSkill(int id) throws Exception {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("DELETE FROM skill WHERE id=?;");
        stmt.setInt(1, id);
        return stmt.execute();
    }

    @Override
    public List<Skill> getByName(String sname) throws Exception {
        List<Skill> result = new ArrayList<>();
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM skill WHERE name LIKE ?;");
        stmt.setString(1, sname);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();

        while (rs.next()) {

            int id = rs.getInt("Id");
            String name = rs.getString("name");
            result.add(new Skill(id, name));

        }
        return result;
    }
}

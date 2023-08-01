package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {
    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int skillId = rs.getInt("skill_id");
        int userId = rs.getInt("id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);

    }
    @Override
    public List<UserSkill> getAllUserSkillById(int userId) throws Exception {
        List<UserSkill> result = new ArrayList<>();
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("SELECT"
                + " u.*, "
                + " us.skill_id, "
                + " s.NAME AS skill_name, "
                + " us.power "
                + " FROM "
                + " user_skill us "
                + " LEFT JOIN USER u ON us.user_id = u.id "
                + " LEFT JOIN skill s ON us.skill_id = s.id "
                + " WHERE "
                + " us.user_id = ? ");
        stmt.setInt(1,userId);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            UserSkill usr = getUserSkill(rs);

            result.add(usr);
        }
        con.close();
        return result;
    }
}

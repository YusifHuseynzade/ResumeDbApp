package com.company.dao.inter;

import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllUserSkillById(int userId) throws Exception;
}

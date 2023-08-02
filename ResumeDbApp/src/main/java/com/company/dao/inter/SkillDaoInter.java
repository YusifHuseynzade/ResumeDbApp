package com.company.dao.inter;

import com.company.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAll() throws Exception;

    public Skill getById(int id) throws Exception;

    boolean updateSkill(Skill u) throws Exception;

    boolean removeSkill(int id) throws Exception;

    public List<Skill> getByName(String name) throws Exception;

    public boolean insertSkill(Skill skl) throws Exception;
}

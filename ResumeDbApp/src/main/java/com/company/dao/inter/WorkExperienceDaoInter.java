package com.company.dao.inter;

import com.company.entity.WorkExperience;

import java.util.List;

public interface WorkExperienceDaoInter {
    public List<WorkExperience> getAllWorkExperienceByUserId(int userId) throws Exception;
}

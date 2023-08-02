package com.company.main;

import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.impl.WorkExperienceDaoImpl;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.dao.inter.WorkExperienceDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){// Factory Pattern
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkillDao(){// Factory Pattern
        return new UserSkillDaoImpl();
    }

    public static WorkExperienceDaoInter instanceWorkExperienceDao() {
        return new WorkExperienceDaoImpl();
    }
    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }
}

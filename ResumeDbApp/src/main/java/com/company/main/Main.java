package com.company.main;


import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.dao.inter.WorkExperienceDaoInter;


public class Main { // java database connectivity = jdbc api specification - Connection, Statement, ResultSet
    public static void main(String[] args) throws Exception {// Loosely coupling - iki obyektin bir birinden asli olmamasi durumudur.
        UserDaoInter userDaoInter = Context.instanceUserDao();
        UserSkillDaoInter userSkillDaoInter = Context.instanceUserSkillDao();
        SkillDaoInter skillDaoInter = Context.instanceSkillDao();
        WorkExperienceDaoInter workExperienceDaoInter = Context.instanceWorkExperienceDao();
        /*List<User> list = userDaoInter.getAllUser();
        System.out.println("list: "+ list); */

        // userDaoInter.getAllUser();
        /* User usr = new User(0,"Yusif","Huseynzade","0552270553","yusif@gmail.com");
        User usr2 = new User(0,"Elcin","Memmedov","0557780653","elcin@gmail.com");
        userDaoInter.addUser(usr2); */
       /* User usr = userDaoInter.getById(1);
        usr.setName("Kamal");
        userDaoInter.updateUser(usr); */
        // List<User> list = userDaoInter.getAllUser();
        System.out.println(userSkillDaoInter.getAllUserSkillById(4));
    }

    }

package com.company.main;


import com.company.bean.User;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class Main { // java database connectivity = jdbc api specification - Connection, Statement, ResultSet
    public static void main(String[] args) throws Exception {// Loosely coupling - iki obyektin bir birinden asli olmamasi durumudur.
        UserDaoInter userDaoInter = Context.instanceUserDao();
        /*List<User> list = userDaoInter.getAllUser();
        System.out.println("list: "+ list); */
        User usr = userDaoInter.getById(1);
        usr.setName("Kamal");
        userDaoInter.updateUser(usr);
        List<User> list = userDaoInter.getAllUser();
        System.out.println("list: "+ list);
    }

    }

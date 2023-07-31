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


        User usr = new User(0,"Yusif","Huseynzade","0552270553","yusif@gmail.com");
        User usr2 = new User(0,"Elcin","Memmedov","0557780653","elcin@gmail.com");
        userDaoInter.addUser(usr2);
       /* User usr = userDaoInter.getById(1);
        usr.setName("Kamal");
        userDaoInter.updateUser(usr); */
        List<User> list = userDaoInter.getAllUser();
        System.out.println("list: "+ list);
    }

    }

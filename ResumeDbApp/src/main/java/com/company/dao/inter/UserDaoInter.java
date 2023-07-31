package com.company.dao.inter;

import com.company.bean.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAllUser() throws Exception;
    public User getById(int userId) throws Exception;
    public boolean updateUser(User u) throws Exception;
    public boolean removeUser(int id) throws Exception;
}

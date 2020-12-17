package com.suep.sos.Service.Implementation;

import com.suep.sos.Dao.UserDao;
import com.suep.sos.Entity.User;
import com.suep.sos.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User getByName(String username) {
        return userDao.findByUsername(username);
    }
 
    public User get(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }

    public int getUserId(String username) {
        return userDao.getByUsername(username).getId();
    }
}

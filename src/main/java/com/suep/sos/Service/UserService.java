package com.suep.sos.Service;

import com.suep.sos.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public boolean isExist(String username);
    public User get(String username, String password);
    public User getByName(String username);
    public void add(User user);
    public int getUserId(String username);
}

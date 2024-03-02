package com.gryffindoraf.gameplus.service;

import com.gryffindoraf.gameplus.dao.RegisterDao;
import com.gryffindoraf.gameplus.entity.db.User;
import com.gryffindoraf.gameplus.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }
}

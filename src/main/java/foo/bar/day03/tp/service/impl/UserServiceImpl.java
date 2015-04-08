package foo.bar.day03.tp.service.impl;

import foo.bar.day03.tp.dao.UserDao;
import foo.bar.day03.tp.domain.Guest;
import foo.bar.day03.tp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public Guest register(Guest guest) {
        return userDao.register(guest);
    }

    @Override
    public Guest findById(Long id) {
        return userDao.findById(id);
    }
}

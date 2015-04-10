package foo.bar.day03.tp.dao.impl;

import com.google.common.collect.ImmutableMap;
import foo.bar.day03.tp.dao.AbstractDao;
import foo.bar.day03.tp.dao.UserDao;
import foo.bar.day03.tp.domain.Guest;
import foo.bar.day03.tp.util.QueryManager;
import org.springframework.stereotype.Repository;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Repository
public class UserDaoImpl extends AbstractDao<Guest> implements UserDao {

    public UserDaoImpl() {
        super(Guest.class);
    }

    @Override
    public Guest register(Guest guest) {
        String sql = QueryManager.getQuery("day03/sql/insertGuest.ftl", ImmutableMap.of("guest", guest));
        Long id = save(sql);
        guest.setId(id);
        return guest;
    }

}

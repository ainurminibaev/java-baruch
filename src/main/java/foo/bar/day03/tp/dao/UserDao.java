package foo.bar.day03.tp.dao;

import foo.bar.day03.tp.domain.Guest;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public interface UserDao {

    Guest register(Guest guest);

    Guest findById(Long id);
}

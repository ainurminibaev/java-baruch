package foo.bar.day03.tp.domain;

import foo.bar.day03.tp.annotation.ClassMapper;
import foo.bar.day03.tp.annotation.Table;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Table("guest")
public class Guest extends BaseEntity {
    private String login;
    private String city;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ClassMapper
    public static RowMapper<Guest> ROW_MAPPER = new RowMapper<Guest>() {
        @Override
        public Guest mapRow(ResultSet resultSet, int i) throws SQLException {
            Guest guest = new Guest();
            guest.setId(resultSet.getLong(1));
            guest.setLogin(resultSet.getString(2));
            guest.setCity(resultSet.getString(3));
            return guest;
        }
    };
}

package foo.bar.day03.tp.domain;

import foo.bar.day03.tp.annotation.Table;

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
}

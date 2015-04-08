package foo.bar.day03.tp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public abstract class AbstractDao {

    JdbcTemplate template;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void postConstruct() {
        template = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public Long save(final String sql) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[]{"id"});
                        return ps;
                    }
                },
                keyHolder);
        return (Long) keyHolder.getKey();
    }

    public <T> T findById(Long id, String table, RowMapper<T> mapper) {
        List<T> query = getTemplate().query("SELECT * FROM " + table, mapper);
        try {
            return query.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}

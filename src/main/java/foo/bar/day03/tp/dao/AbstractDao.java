package foo.bar.day03.tp.dao;

import foo.bar.day03.tp.annotation.ClassMapper;
import foo.bar.day03.tp.annotation.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public abstract class AbstractDao<T> {

    JdbcTemplate template;

    @Autowired
    DataSource dataSource;

    Class<T> type;

    String tableName;

    RowMapper<T> mapper;

    public AbstractDao(Class<T> clazz) {
        if (clazz != null) {
            this.type = clazz;
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            if (tableAnnotation == null) {
                throw new IllegalStateException("No Table annotation");
            }
            for (Field field : clazz.getFields()) {
                if (field.getAnnotation(ClassMapper.class) != null) {
                    try {
                        mapper = (RowMapper<T>) field.get(clazz.newInstance());
                    } catch (Exception e) {
                        throw new IllegalStateException("Cannon instatiate Abstract DAO");
                    }
                }
            }
            tableName = tableAnnotation.value();
        }
    }

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

    public T findById(Long id) {
        List<T> query = getTemplate().query("SELECT * FROM " + tableName + " WHERE id=" + id, mapper);
        try {
            return query.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public List<T> findAll() {
        return getTemplate().query("SELECT * FROM " + tableName, mapper);
    }
}

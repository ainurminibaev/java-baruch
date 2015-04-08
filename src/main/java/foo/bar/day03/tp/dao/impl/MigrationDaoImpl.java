package foo.bar.day03.tp.dao.impl;

import foo.bar.day03.tp.dao.AbstractDao;
import foo.bar.day03.tp.dao.MigrationDao;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Repository
public class MigrationDaoImpl extends AbstractDao implements MigrationDao {

    public MigrationDaoImpl() {
        super(null);
    }

    @Override
    public boolean alreadyMigrated(final String fileName) {
        List<Integer> query = getTemplate().query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM migrations m WHERE m.file_name = ?");
                preparedStatement.setString(1, fileName);
                return preparedStatement;
            }
        }, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(1);
            }
        });
        return query.get(0) != 0;
    }

    private void markMigrated(final String fileName) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO migrations(file_name) VALUES(?)");
                preparedStatement.setString(1, fileName);
                return preparedStatement;
            }
        };
        getTemplate().update(creator);
    }

    @Override
    public void migrate(File sqlFile) {
        if (alreadyMigrated(sqlFile.getAbsolutePath())) {
            return;
        }
        try {
            String sqlStr = readFile(sqlFile.getAbsolutePath(), StandardCharsets.UTF_8);
            getTemplate().execute(sqlStr);
            markMigrated(sqlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void migrate(String folderName) {
        File migrationDir = new File(getClass().getClassLoader().getResource("day03/migrations/").getFile());
        for (File migration : migrationDir.listFiles()) {
            migrate(migration);
        }
    }

    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


    @PostConstruct
    public void init() {
        getTemplate().execute("create table if not exists migrations(file_name VARCHAR (512))");
    }
}

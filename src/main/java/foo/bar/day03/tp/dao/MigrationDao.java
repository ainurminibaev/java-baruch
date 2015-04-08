package foo.bar.day03.tp.dao;

import java.io.File;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public interface MigrationDao {

    boolean alreadyMigrated(String fileName);

    void migrate(File sql);

    void migrate(String folderName);

}

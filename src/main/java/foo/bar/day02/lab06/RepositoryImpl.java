package foo.bar.day02.lab06;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {
    @Override
    public void persistMessage(String msg) {
        throw new DatabaseException("Failed to save msg");
    }
}

package foo.bar.day01.lab09;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class DestroyablePrototype {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void destroy() {
        System.out.println("Finalize object");
    }
}

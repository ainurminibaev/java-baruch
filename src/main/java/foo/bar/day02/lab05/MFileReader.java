package foo.bar.day02.lab05;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class MFileReader {
    private long fileSize;

    //@Value("${file.path}")
    @Value("file.txt")
    private String path;

    @PostConstruct
    public void postConstruct() {
        //TODO
        File f = new File(path);
        fileSize = f.length();
        System.out.println("Read file: " + fileSize);
    }

    public long getFileSize() {
        return fileSize;
    }
}

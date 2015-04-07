package foo.bar.day02.lab05;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class MFileWriter {

    private String lineToWrite = "Fine;";
    private long fileSize;
    //@Value("${file.path}")
    @Value("file.txt")
    private String path;

    @PostConstruct
    public void postConstruct() {
        try {
            try (FileWriter fileWriter = new FileWriter(path)) {
                fileWriter.write(lineToWrite);
                fileSize = lineToWrite.getBytes().length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wrote file: " + fileSize);
    }

    public long getFileSize() {
        return fileSize;
    }
}

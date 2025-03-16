import java.io.*;

abstract class Image {
    String fileName;

    public Image(String fileName) {
        this.fileName = fileName;
    }

    public abstract void saveToFile() throws IOException;
}
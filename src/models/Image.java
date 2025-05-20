package models;

public abstract class Image {
    protected final String filename;

    public Image(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }


    public abstract void display();
}

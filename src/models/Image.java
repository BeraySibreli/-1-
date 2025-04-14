package models;

public abstract class Image {
    protected String filename;

    public Image(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public abstract void save();
    public abstract void saveAs(String newFilename);
}
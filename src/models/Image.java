package models;

public abstract class Image {
    protected final String filename;

    public Image(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    // Може да се използва за визуализация, тестване или разширяване
    public abstract void display();
}

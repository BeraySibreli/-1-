package models;


public class RasterImage extends Image {
    public RasterImage(String filename) {
        super(filename);
    }

    @Override
    public void save() {
        System.out.println("Saving image: " + filename);
    }

    @Override
    public void saveAs(String newFilename) {
        System.out.println("Saving image " + filename + " as " + newFilename);
        this.filename = newFilename;
    }
}
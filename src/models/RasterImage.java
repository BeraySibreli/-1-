package models;

public class RasterImage extends Image {

    public RasterImage(String filename) {
        super(filename);
    }

    @Override
    public void display() {

        System.out.println("Displaying image: " + filename);
    }
}

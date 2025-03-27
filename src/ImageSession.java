import java.util.*;

class ImageSession {
    private int id;
    private List<RasterImage> images = new ArrayList<>();

    public ImageSession(int id, String filename) {
        this.id = id;
        images.add(new RasterImage(filename));
    }

    public void addImage(String filename) {
        images.add(new RasterImage(filename));
        System.out.println("Added: " + filename);
    }

    public void applyTransformation(String transformation) {
        if (!images.isEmpty()) images.getLast().applyTransformation(transformation);
        else System.out.println("No images to transform.");
    }

    public void undo() {
        if (!images.isEmpty()) images.getLast().undo();
        else System.out.println("No transformations to undo.");
    }

    public void sessionInfo() {
        System.out.println("Session " + id + ": " + images);
    }

    public void save() {
        images.forEach(RasterImage::save);
    }

    public void saveAs(String filename) {
        if (!images.isEmpty()) images.getFirst().saveAs(filename);
        else System.out.println("No images to save.");
    }

    public void close() {
        System.out.println("Closing session " + id);
    }
}

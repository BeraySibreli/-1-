import java.util.*;

class RasterImage extends Image {
    private List<String> transformations = new ArrayList<>();

    public RasterImage(String filename) {
        super(filename);
    }

    public void applyTransformation(String transformation) {
        transformations.add(transformation);
        System.out.println("Applied transformation: " + transformation + " to " + filename);
    }

    public void undo() {
        if (!transformations.isEmpty()) {
            String undone = transformations.remove(transformations.size() - 1);
            System.out.println("Undid transformation: " + undone + " on " + filename);
        } else {
            System.out.println("No transformations to undo for " + filename);
        }
    }

    public void save() {
        System.out.println("Saving image: " + filename);
    }

    public void saveAs(String newFilename) {
        System.out.println("Saving " + filename + " as " + newFilename);
    }

    public List<String> getTransformations() {
        return transformations;
    }
}

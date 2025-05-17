package core;

import models.Image;
import models.RasterImage;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private final int id;
    private final List<Image> images = new ArrayList<>();
    private final List<String> transformations = new ArrayList<>();

    public Session(int id, String firstImageName) {
        this.id = id;
        this.images.add(new RasterImage(firstImageName));
        System.out.println("Session with ID: " + id + " started");
        System.out.println("Image \"" + firstImageName + "\" added");
    }

    public int getId() {
        return id;
    }

    public void addImage(String filename) {
        images.add(new RasterImage(filename));
        System.out.println("Image \"" + filename + "\" added");
    }

    public void addTransformation(String t) {
        transformations.add(t);
        System.out.println("Transformation '" + t + "' queued.");
    }

    public void undoLastTransformation() {
        if (!transformations.isEmpty()) {
            String removed = transformations.remove(transformations.size() - 1);
            System.out.println("Undid transformation: " + removed);
        } else {
            System.out.println("No transformations to undo.");
        }
    }

    public void showInfo() {
        System.out.println("Session ID: " + id);
        System.out.print("Images: ");
        for (Image img : images) {
            System.out.print(img.getFilename() + " ");
        }
        System.out.println("\nPending transformations: " + transformations);
    }

    public void save() {
        System.out.println("Saving all images with applied transformations: " + transformations);
    }

    public void saveAs(String newName) {
        if (!images.isEmpty()) {
            System.out.println("Saving first image as: " + newName);
        }
    }

    public void close() {
        System.out.println("Closing session " + id);
    }

    public void switchTo() {
        System.out.println("You switched to session with ID: " + id);
    }

    public boolean containsImage(String name) {
        return images.stream().anyMatch(img -> img.getFilename().equals(name));
    }

    public void collage(String dir, String img1, String img2, String outImg) {
        if (!containsImage(img1) || !containsImage(img2)) {
            System.out.println("Cannot make collage: image(s) not found.");
            return;
        }
        if (img1.endsWith("pgm") && !img2.endsWith("pgm")) {
            System.out.println("Cannot make a collage from different types!");
        } else {
            System.out.println("New collage \"" + outImg + "\" created");
            images.add(new RasterImage(outImg));
        }
    }
}

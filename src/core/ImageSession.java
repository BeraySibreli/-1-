
package core;

import models.RasterImage;
import transforms.Transformation;

import java.util.*;


public class ImageSession {
    private final int id;
    private final List<RasterImage> images = new ArrayList<>();
    private final List<Transformation> transformations = new ArrayList<>();

    public ImageSession(int id, String filename) {
        this.id = id;
        images.add(new RasterImage(filename));
        System.out.println("Session with ID: " + id + " started");
        System.out.println("Image " + filename + " added");
    }

    public int getId() {
        return id;
    }

    public void addImage(String filename) {
        images.add(new RasterImage(filename));
        System.out.println("Image " + filename + " added");
    }

    public void applyTransformation(Transformation t) {
        transformations.add(t);
        System.out.println("Transformation " + t.getName() + " queued.");
    }

    public void undo() {
        if (!transformations.isEmpty()) {
            Transformation removed = transformations.remove(transformations.size() - 1);
            System.out.println("Undid transformation: " + removed.getName());
        } else {
            System.out.println("No transformations to undo.");
        }
    }

    public void sessionInfo() {
        System.out.println("Session ID: " + id);
        System.out.print("Name of images in the session: ");
        for (RasterImage img : images) {
            System.out.print(img.getFilename() + " ");
        }
        System.out.println("\nPending transformations:");
        for (Transformation t : transformations) {
            System.out.println("- " + t.getName());
        }
    }

    public void save() {
        System.out.println("Saving all images in session " + id);
    }

    public void saveAs(String filename) {
        if (!images.isEmpty()) {
            System.out.println("Saving first image as " + filename);
        } else {
            System.out.println("No image to save.");
        }
    }

    public void close() {
        System.out.println("Closing session " + id);
    }

    public void collage(String direction, String img1, String img2, String outImage) {
        if (direction == null || (!direction.equals("horizontal") && !direction.equals("vertical"))) {
            System.out.println("Invalid collage direction. Use 'horizontal' or 'vertical'.");
            return;
        }

        boolean found1 = false, found2 = false;
        for (RasterImage img : images) {
            if (img.getFilename().equals(img1)) found1 = true;
            if (img.getFilename().equals(img2)) found2 = true;
        }

        if (!found1 || !found2) {
            System.out.println("Cannot make collage: one or both images not found in session.");
        } else {
            System.out.println("New collage " + outImage + " created");
            images.add(new RasterImage(outImage));
        }
    }
}

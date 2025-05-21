package core;

import models.Image;
import models.RasterImage;

import java.util.*;

/**
 * Представлява сесия за работа с изображения.
 * <p>
 * Сесията съдържа списък от изображения и списък от трансформации, които могат да бъдат приложени.
 */
public class Session {

    /**
     * Уникалният идентификатор на сесията.
     */
    private final int id;

    /**
     * Списък с изображения, асоциирани със сесията.
     */
    private final List<Image> images = new ArrayList<>();

    /**
     * Списък с трансформации, които предстои да бъдат приложени.
     */
    private final List<String> transformations = new ArrayList<>();

    /**
     * Създава нова сесия с даден идентификатор и първоначално изображение.
     *
     * @param id             уникалният идентификатор на сесията
     * @param firstImageName име на първото изображение в сесията
     */
    public Session(int id, String firstImageName) {
        this.id = id;
        this.images.add(new RasterImage(firstImageName));
        System.out.println("Session with ID: " + id + " started");
        System.out.println("Image \"" + firstImageName + "\" added");
    }

    /**
     * Връща идентификатора на сесията.
     *
     * @return идентификаторът на сесията
     */
    public int getId() {
        return id;
    }

    /**
     * Добавя ново изображение към сесията.
     *
     * @param filename името на файла на изображението
     */
    public void addImage(String filename) {
        images.add(new RasterImage(filename));
        System.out.println("Image \"" + filename + "\" added");
    }

    /**
     * Добавя нова трансформация в списъка с чакащи трансформации.
     *
     * @param t името на трансформацията
     */
    public void addTransformation(String t) {
        transformations.add(t);
        System.out.println("Transformation '" + t + "' queued.");
    }

    /**
     * Премахва последната добавена трансформация.
     * Ако няма трансформации, се извежда подходящо съобщение.
     */
    public void undoLastTransformation() {
        if (!transformations.isEmpty()) {
            String removed = transformations.remove(transformations.size() - 1);
            System.out.println("Undid transformation: " + removed);
        } else {
            System.out.println("No transformations to undo.");
        }
    }

    /**
     * Показва информация за текущата сесия – изображения и трансформации.
     */
    public void showInfo() {
        System.out.println("Session ID: " + id);
        System.out.print("Images: ");
        for (Image img : images) {
            System.out.print(img.getFilename() + " ");
        }
        System.out.println("\nPending transformations: " + transformations);
    }

    /**
     * Запазва изображенията, като прилага всички натрупани трансформации.
     */
    public void save() {
        System.out.println("Saving all images with applied transformations: " + transformations);
    }

    /**
     * Запазва първото изображение под ново име.
     *
     * @param newName новото име на изображението
     */
    public void saveAs(String newName) {
        if (!images.isEmpty()) {
            System.out.println("Saving first image as: " + newName);
        }
    }

    /**
     * Затваря сесията.
     */
    public void close() {
        System.out.println("Closing session " + id);
    }

    /**
     * Извежда съобщение за преминаване към тази сесия.
     */
    public void switchTo() {
        System.out.println("You switched to session with ID: " + id);
    }

    /**
     * Проверява дали дадено изображение по име се съдържа в сесията.
     *
     * @param name името на изображението
     * @return {@code true} ако изображението е намерено, {@code false} в противен случай
     */
    public boolean containsImage(String name) {
        return images.stream().anyMatch(img -> img.getFilename().equals(name));
    }

    /**
     * Създава ново колаж-изображение от две съществуващи изображения.
     * Изображенията трябва да са от съвместим тип (например и двете да са PGM).
     *
     * @param dir    директорията, в която ще се съхранява новото изображение
     * @param img1   име на първото изображение
     * @param img2   име на второто изображение
     * @param outImg име на резултатното колаж-изображение
     */
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

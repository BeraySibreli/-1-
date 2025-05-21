package models;

/**
 * Абстрактен клас, представящ изображение.
 * <p>
 * Всеки наследяващ клас трябва да имплементира метода {@link #display()}.
 */
public abstract class Image {

    /**
     * Името на файла на изображението.
     */
    protected final String filename;

    /**
     * Конструктор на класа Image.
     *
     * @param filename името на файла на изображението
     */
    public Image(String filename) {
        this.filename = filename;
    }

    /**
     * Връща името на файла на изображението.
     *
     * @return името на файла
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Абстрактен метод за показване на изображението.
     * <p>
     * Всеки подклас трябва да предостави своя реализация за визуализиране на изображението.
     */
    public abstract void display();
}

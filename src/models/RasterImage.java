package models;

/**
 * Клас, представляващ растерно изображение.
 * <p>
 * Наследява абстрактния клас {@link Image} и предоставя реализация на метода {@link #display()}.
 */
public class RasterImage extends Image {

    /**
     * Конструктор на класа RasterImage.
     *
     * @param filename името на файла на растерното изображение
     */
    public RasterImage(String filename) {
        super(filename);
    }

    /**
     * Извежда името на растерното изображение в конзолата.
     * <p>
     * Реализация на абстрактния метод {@link Image#display()}.
     */
    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

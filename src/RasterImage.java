import java.io.*;

class RasterImage extends Image {
     int width;
     int height;
     int[][] pixels;
     int[][] previousPixels;

    // Конструктор на класа
    public RasterImage(String fileName, int width, int height) {
        super(fileName);
        this.width = width;
        this.height = height;
        this.pixels = new int[height][width];
        this.previousPixels = new int[height][width];
    }

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public void saveState() {
        for (int i = 0; i < height; i++) {
            System.arraycopy(pixels[i], 0, previousPixels[i], 0, width);
        }
    }

    @Override
    public void saveToFile() throws IOException {

    }
}

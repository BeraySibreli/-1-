class Image {
    protected String filename;

    public Image(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void save() {
        System.out.println("Saving image: " + filename);
    }

    public void saveAs(String newFilename) {
        System.out.println("Saving " + filename + " as " + newFilename);
        this.filename = newFilename;
    }
}

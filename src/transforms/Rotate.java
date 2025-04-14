
package transforms;

public class Rotate implements Transformation {
    private final String direction;

    public Rotate(String direction) {
        this.direction = direction;
    }

    @Override
    public String getName() {
        return "rotate " + direction;
    }
}

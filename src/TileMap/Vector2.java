package TileMap;

public class Vector2 {
    public double x = 0;
    public double y = 0;

    public static final Vector2 UP = new Vector2(0, -1);
    public static final Vector2 DOWN = new Vector2(0, 1);
    public static final Vector2 LEFT = new Vector2(-1, 0);
    public static final Vector2 RIGHT = new Vector2(1, 0);

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(double[] coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    public Vector2 addToThis(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Vector2 add(Vector2 other) {
        Vector2 a = new Vector2(x, y);
        a.x += other.x;
        a.y += other.y;
        return a;
    }

    public Vector2 sub(Vector2 other) {
        Vector2 a = new Vector2(x, y);
        a.x -= other.x;
        a.y -= other.y;
        return a;
    }

    public String toString() {
        return "X: " + x + "  Y: "+ y;
    }
}
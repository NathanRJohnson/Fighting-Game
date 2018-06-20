package gdx.game.Objects;

public class PVector {
    public float x, y;

    public PVector(float _x, float _y) {
        x = _x;
        y = _y;
    }

    public void add(PVector v) {
        x = x + v.x;
        y = y + v.y;
    }

    public void sub(PVector v) {
        x = x - v.x;
        y = y - v.y;
    }

    public void mult(float f) {
        x = x * f;
        y = y * f;
    }

    public void div(float f) {
        x = x / f;
        y = y / f;
    }

    public double mag() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double m = mag();
        if (m != 0) {
            div((float) m);
        }
    }

    public void limit(float fMaxSpeed) {
        normalize();
        mult(fMaxSpeed);

    }

    public PVector get() {
        PVector vCopy = new PVector(x, y);
        return vCopy;
    }
}


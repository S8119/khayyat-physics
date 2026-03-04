package khayyat.physics;

import java.util.Objects;

public class Force
{
    private final double x;
    private final double y;

    public Force(double xVal, double yVal)
    {
        x = xVal;
        y = yVal;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getDegrees()
    {
        return Math.toDegrees(Math.atan2(y, x));
    }

    public double getMagnitude()
    {
        return Math.sqrt(x * x + y * y);
    }

    public Force add(Force other)
    {
        return new Force(this.x + other.x, this.y + other.y);
    }

    /**
     * @return a new Force proportionate to this force where the magnitude is 1
     */
    public Force normalize()
    {
        double magnitude = getMagnitude(); // so magnitude only needs to be calculated once
        return new Force(x / magnitude, y / magnitude);
    }

    /**
     * @return a new Force with x and y multiplied by the scale
     */
    public Force scale(double scale)
    {
        return new Force(x * scale, y * scale);
    }

    public String toString()
    {
        return "x: " + x + ", y: " + y + ", magnitude: " + getMagnitude() + ", degrees: " + getDegrees();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Force force = (Force) o;
        return Double.compare(x, force.x) == 0 && Double.compare(y, force.y) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
}

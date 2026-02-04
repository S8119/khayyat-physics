public class Force
{
    private double x;
    private double y;

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
        return Math.toDegrees(Math.atan2(y,x));
    }

    public double getMagnitude()
    {
        return Math.sqrt(x*x + y*y);
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
        return new Force(x/magnitude, y/magnitude);
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
}

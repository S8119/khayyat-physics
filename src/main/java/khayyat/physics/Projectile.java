package khayyat.physics;

public class Projectile
{
    public static final Force GRAVITY = new Force(0, -9.8);
    private final double forceY;
    private final double forceX;
    private Force force;
    private double x;
    private double y;

    public Projectile(Force force, double x, double y)
    {
        this.force = force;
        forceY = force.getY();
        forceX = force.getX();
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public Force getForce()
    {
        return force;
    }

    public double getApex()
    {
        return (forceY * forceY) / (2 * GRAVITY.getMagnitude());
    }

    public double getApexX()
    {
        return (forceX * forceY) / (GRAVITY.getMagnitude());
    }

    public void apply(double time)
    {
        Force scaledGravity = GRAVITY.scale(time);
        force = force.add(scaledGravity);
        Force scaledForce = force.scale(time);
        x += scaledForce.getX();
        y += scaledForce.getY();
    }
}
package khayyat.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForceTest
{

    @Test
    public void getDegrees()
    {
        //given
        Force f = new Force(3, 4);

        //when
        double degrees = f.getDegrees();

        //then
        assertEquals(53.13, degrees, 0.1);
    }

    @Test
    public void getMagnitude()
    {
        //given
        Force f = new Force(3, 4);

        //when
        double magnitude = f.getMagnitude();

        //then
        assertEquals(5, magnitude, 0.1);
    }

    @Test
    public void add()
    {
        //given
        Force f1 = new Force(7, 3);
        Force f2 = new Force(-4, 12);

        //when
        Force f3 = f1.add(f2);

        //then
        assertEquals(3, f3.getX(), 0.1);
        assertEquals(15, f3.getY(), 0.1);
    }

    @Test
    public void normalize()
    {
        //given
        Force f1 = new Force(3, 4);

        //when
        Force f2 = f1.normalize();

        //then
        assertEquals(0.6, f2.getX(), 0.1);
        assertEquals(0.8, f2.getY(), 0.1);
    }

    @Test
    public void scale()
    {
        //given
        Force f1 = new Force(3, 4);

        //when
        Force f2 = f1.scale(11);

        //then
        assertEquals(33, f2.getX(), 0.1);
        assertEquals(44, f2.getY(), 0.1);
    }

    @Test
    public void gravity()
    {
        //given
        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.001);
        double x = 0;
        double y = 0;
        Force f1 = new Force(37.0365, 28.9360);

        //when
        for (double i = 0; i < 5.0; i += 0.001)
        {
            f1 = f1.add(scaledGravity);
            Force scaledF1 = f1.scale(0.001);
            x += scaledF1.getX();
            y += scaledF1.getY();
        }

        //then
        assertEquals(185.1825, x, 0.1);
        assertEquals(22.1555, y, 0.1);
    }
}
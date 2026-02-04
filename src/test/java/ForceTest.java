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
}
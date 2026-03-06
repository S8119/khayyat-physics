package khayyat.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest
{

    @Test
    void apply()
    {
        //given
        Projectile p = new Projectile(new Force(37.0365, 28.9360), 0, 0);

        //when
        for (double i = 0; i < 5; i += 0.001)
        {
            p.apply(.001);
        }

        //then
        assertEquals(185.1825, p.getX(), .1);
        assertEquals(22.1555, p.getY(), .1);
        assertEquals(37.0365, p.getForce().getX(), .1);
        assertEquals(-20.0640, p.getForce().getY(), .1);
    }

    @Test
    void getApex()
    {
        //given
        Projectile p = new Projectile(new Force(37.0365, 28.9360), 0, 0);

        //when
        double apex = p.getApex();

        //then
        assertEquals(25, apex, .1);
    }
}
package khayyat.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent
{
    private Force force = new Force(37.0365, 28.9360);
    private double time = 5;

    public void setForce(Force force)
    {
        this.force = force;
        repaint();
    }

    public void setTime(double time)
    {
        this.time = time;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Projectile p = new Projectile(force, 0, 0);

        g.translate(0, getHeight());
        for (double i = 0; i < time; i += 0.001)
        {
            p.apply(.001);
            g.drawOval((int) p.getX(), (int) -p.getY(), 1, 1);
        }
    }
}
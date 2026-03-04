package khayyat.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent
{
    private Force force = new Force(37.0365, 28.9360);
    private Projectile p = new Projectile(force, 0, 0);
    private double time = 5;

    public void setForce(Force force)
    {
        this.force = force;
        p = new Projectile(force, 0, 0);
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

        g.setColor(new Color(150, 200, 255));
        for (int i = 0; i < getWidth(); i += 20)
        {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int i = getHeight(); i > 0; i -= 20) //Starting from getHeight, not 0, so lines start on bottom of screen
        {
            g.drawLine(0, i, getWidth(), i);
        }

        g.translate(0, getHeight());

        g.setColor(Color.black);
        p.apply(.01);
        g.fillOval((int) p.getX(), (int) -p.getY(), 10, 10);

        g.setColor(Color.green);
        g.drawLine(0, 0, (int) force.getX(), (int) -force.getY());
    }
}
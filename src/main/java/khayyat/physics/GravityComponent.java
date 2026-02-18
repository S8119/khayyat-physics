package khayyat.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Projectile p = new Projectile(new Force(37.0365, 28.9360), 0, 0);

        g.translate(0, getHeight());
        for (double i = 0; i < 5; i += 0.001)
        {
            p.apply(.001);
            g.drawOval((int) p.getX(), (int) -p.getY(), 1, 1);
        }
    }
}

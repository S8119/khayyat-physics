package khayyat.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //given
        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.001);
        double x = 0;
        double y = 0;
        Force f1 = new Force(37.0365, 28.9360);

        g.drawOval((int) x, (int) y, 1, 1);
        //when
        for(double i = 0; i < 5.0; i += 0.001)
        {
            f1 = f1.add(scaledGravity);
            Force scaledF1 = f1.scale(0.001);
            x += scaledF1.getX();
            y += scaledF1.getY();
            g.drawOval((int) x, getHeight() - (int) y, 1, 1);
        }
    }
}

package khayyat.physics;

import javax.swing.*;
import java.text.DecimalFormat;

public class GravityController
{
    private final GravityComponent gravityComponent;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField timeField;
    private final JLabel angleLabel;
    private final JLabel magLabel;
    private final JLabel apexLabel;

    public GravityController(
            GravityComponent gc, JTextField x, JTextField y, JTextField time, JLabel angle, JLabel mag, JLabel apex)
    {
        gravityComponent = gc;
        xField = x;
        yField = y;
        timeField = time;
        angleLabel = angle;
        magLabel = mag;
        apexLabel = apex;
    }

    public void updateForce(double x, double y)
    {
        Force force = new Force(x, y);
        gravityComponent.setForce(force);
        gravityComponent.setTime(Double.parseDouble(timeField.getText()));
        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));

        DecimalFormat df = new DecimalFormat("#.##");
        angleLabel.setText("Angle (Degrees): " + df.format(force.getDegrees()));
        magLabel.setText("Magnitude: " + df.format(force.getMagnitude()));

        Projectile projectile = new Projectile(force, 0, 0);
        apexLabel.setText("Apex: " + df.format(projectile.getApex()));
    }
}

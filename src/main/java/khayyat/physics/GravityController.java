package khayyat.physics;

import javax.swing.*;

public class GravityController
{
    private final GravityComponent gravityComponent;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField timeField;
    private final JLabel angleLabel;
    private final JLabel magLabel;

    public GravityController(
            GravityComponent gc, JTextField x, JTextField y, JTextField time, JLabel angle, JLabel mag)
    {
        gravityComponent = gc;
        xField = x;
        yField = y;
        timeField = time;
        angleLabel = angle;
        magLabel = mag;
    }

    public void updateForce(double x, double y)
    {
        Force force = new Force(x, y);
        gravityComponent.setForce(force);
        gravityComponent.setTime(Double.parseDouble(timeField.getText()));
        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));
        angleLabel.setText("Angle (Degrees): " + force.getDegrees());
        magLabel.setText("Magnitude: " + force.getMagnitude());
    }
}

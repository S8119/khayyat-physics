package khayyat.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GravityFrame extends JFrame
{
    public GravityFrame()
    {
        setSize(300, 400);
        setTitle("Gravity Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        final JLabel xLabel = new JLabel("Force x");
        JTextField xField = new JTextField("37.0365");
        final JLabel yLabel = new JLabel("Force y");
        JTextField yField = new JTextField("28.9360");
        final JLabel timeLabel = new JLabel("Time");
        JTextField timeField = new JTextField("5.0");

        final JButton button = new JButton("Draw");

        JLabel angleLabel = new JLabel("Angle (Degrees): ");
        JLabel magLabel = new JLabel("Magnitude: ");

        GravityComponent gravityComponent = new GravityComponent();

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Force force = new Force(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText())
                );
                Projectile projectile = new Projectile(force, 0, 0);
                gravityComponent.setForce(force);
                double time = Double.parseDouble(timeField.getText());
                gravityComponent.setTime(time);
                projectile.apply(time);
                Force forceAfterTime = projectile.getForce();
                angleLabel.setText("Angle (Degrees): " + forceAfterTime.getDegrees());
                magLabel.setText("Magnitude: " + forceAfterTime.getMagnitude());
            }
        });

        JPanel northPanel = new JPanel();
        northPanel.add(xLabel);
        northPanel.add(xField);
        northPanel.add(yLabel);
        northPanel.add(yField);
        northPanel.add(timeLabel);
        northPanel.add(timeField);
        northPanel.add(button);
        northPanel.add(angleLabel);
        northPanel.add(magLabel);
        add(northPanel, BorderLayout.NORTH);

        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
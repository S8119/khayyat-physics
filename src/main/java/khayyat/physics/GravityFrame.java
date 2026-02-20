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

        JLabel xLabel = new JLabel("Force x");
        JTextField xField = new JTextField("37.0365");
        JLabel yLabel = new JLabel("Force y");
        JTextField yField = new JTextField("28.9360");
        JLabel timeLabel = new JLabel("Time");
        JTextField timeField = new JTextField("5.0");

        JButton button = new JButton("Draw");

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
                gravityComponent.setForce(force);
                gravityComponent.setTime(Double.parseDouble(timeField.getText()));
                angleLabel.setText("Angle (Degrees): " + force.getDegrees());
                magLabel.setText("Magnitude: " + force.getMagnitude());
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
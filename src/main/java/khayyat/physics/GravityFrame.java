package khayyat.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        gravityComponent.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Force force = new Force(e.getX(), gravityComponent.getHeight() - e.getY());
                gravityComponent.setForce(force);
                xField.setText(String.valueOf(force.getX()));
                yField.setText(String.valueOf(force.getY()));
                angleLabel.setText("Angle (Degrees): " + force.getDegrees());
                magLabel.setText("Magnitude: " + force.getMagnitude());
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        gravityComponent.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                Force force = new Force(e.getX(), gravityComponent.getHeight() - e.getY());
                xField.setText(String.valueOf(force.getX()));
                yField.setText(String.valueOf(force.getY()));
                gravityComponent.setForce(force);
                angleLabel.setText("Angle (Degrees): " + force.getDegrees());
                magLabel.setText("Magnitude: " + force.getMagnitude());
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });

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
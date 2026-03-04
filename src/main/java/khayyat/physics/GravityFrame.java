package khayyat.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame
{
    public GravityFrame()
    {
        setSize(600, 400);
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

        GravityController gravityController = new GravityController(
                gravityComponent, xField, yField, timeField, angleLabel, magLabel);

        gravityComponent.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                gravityController.updateForce(e.getX(), gravityComponent.getHeight() - e.getY());
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
                gravityController.updateForce(e.getX(), gravityComponent.getHeight() - e.getY());
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
                gravityController.updateForce(Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText())
                );
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

        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    gravityComponent.repaint();
                    try
                    {
                        Thread.sleep(16);
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args)
    {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
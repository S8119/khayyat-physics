package khayyat.physics;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

class GravityControllerTest
{

    @Test
    void updateForce()
    {
        //given
        GravityComponent gravityComponent = mock();
        JTextField xField = mock();
        JTextField yField = mock();
        JTextField timeField = mock();
        JLabel angleLabel = mock();
        JLabel magLabel = mock();
        JLabel apexLabel = mock();
        doReturn("7").when(xField).getText();
        doReturn("5").when(yField).getText();
        doReturn("5").when(timeField).getText();
        GravityController controller = new GravityController(
                gravityComponent, xField, yField, timeField, angleLabel, magLabel, apexLabel);

        //when
        controller.updateForce(7, 5);

        //then
        verify(gravityComponent).setForce(new Force(7, 5));
        verify(gravityComponent).setTime(5);
        verify(xField).setText("7.0");
        verify(yField).setText("5.0");
        verify(angleLabel).setText("Angle (Degrees): 35.5377");
        verify(magLabel).setText("Magnitude: 8.6023");
        verify(apexLabel).setText("Apex: 1.2755");
    }
}
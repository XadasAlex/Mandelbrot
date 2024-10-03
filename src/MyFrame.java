import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class MyFrame extends JFrame {
    private final Mandelbrot mb;
    private int windowHeight = 700;
    private int windowWidth = 700;
    // public JPanel sliderPanel = new JPanel();
    // public JLabel iterLabel = new JLabel();
    // public JSlider iterSlider = new JSlider();
    MyFrame(Mandelbrot mb) {
        // basic init
        this.setVisible(true);
        this.setSize(windowWidth,windowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mb = mb;
    }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;

        g.setColor(Color.black);
        for(double x = 0; x < windowWidth; x++) {
            for(double y = 0; y < windowHeight; y++) {
                // percentage where Pixel is on screen
                double xPercentage = x / windowWidth;
                double yPercentage = y / windowHeight;

                double cReal = mb.getCReal(xPercentage);
                double cImaginary = mb.getCImaginary(yPercentage);

                double zReal = 0;
                double zImaginary = 0;

                int iter = 0;
                while (iter < mb.maxIter && zReal * zReal + zImaginary * zImaginary <= 4)
                {
                    double temp = zReal * zReal - zImaginary * zImaginary + cReal;
                    zImaginary = 2 * zReal * zImaginary + cImaginary;
                    zReal = temp;
                    iter++;
                }

                if (iter >= mb.maxIter) {
                    g.setColor(Color.black);
                    g.drawRect((int)x, (int)y, 1, 1);
                } else {
                    g.setColor(Color.white);
                    g.drawRect((int)x, (int)y, 1, 1);
                }
            }
        }


    }
}
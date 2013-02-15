package jp.samples.app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Author: Jirka Pénzeš
 * Date: 15.2.13
 * Time: 13:48
 */
public class MainFrame extends JFrame {

    private JPanel contentPane;

    public MainFrame() {
        initializeComponents();
    }

    private JPanel makeContent(int index) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new Label("some content here " + index));
        return panel;
    }

    private void initializeComponents() {
        setTitle("Extended controls");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.white);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(contentPane, BorderLayout.CENTER);
        pack();
    }
}

package jp.samples.app;

import jp.controls.tabControl.TabControl;
import jp.controls.tabControl.TabItem;

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
        tabControlSample();
    }

    // how use tab-control
    private void tabControlSample() {
        JPanel tamItemPanel1 = makeContent(1);
        JPanel tamItemPanel2 = makeContent(2);
        JPanel tamItemPanel3 = makeContent(3);
        JPanel tamItemPanel4 = makeContent(4);
        JPanel tamItemPanel5 = makeContent(5);

        TabControl tabControl = new TabControl();
        tabControl.addTabItem(new TabItem("Tab item 1", tamItemPanel1));
        tabControl.addTabItem(new TabItem("Tab item 2", tamItemPanel2));
        tabControl.addTabItem(new TabItem("Tab item 3", tamItemPanel3));
        tabControl.addTabItem(new TabItem("Tab item 4", tamItemPanel4));
        tabControl.addTabItem(new TabItem("Tab item 5", tamItemPanel5));

        contentPane.add(tabControl, BorderLayout.CENTER);
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

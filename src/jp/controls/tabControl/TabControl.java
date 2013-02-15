package jp.controls.tabControl;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Jirka Pénzeš
 * Date: 15.2.13
 * Time: 13:56
 */
public class TabControl extends JComponent {

    private TabGroupControl tabGroupControl;
    private TabPanel tabPanel;

    public TabControl() {
        setLayout(new BorderLayout());

        tabPanel = new TabPanel();
        add(tabPanel, BorderLayout.CENTER);

        JPanel tabGroupContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(tabGroupContainer, BorderLayout.NORTH);
        tabGroupControl = new TabGroupControl(tabPanel);
        tabGroupContainer.add(tabGroupControl);
    }

    public void addTabItem(TabItem tabItem) {
        tabItem.getPanel().setBackground(new Color(231, 231, 231));
        tabGroupControl.addTabItem(tabItem);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}

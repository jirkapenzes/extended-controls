package jp.controls.tabControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Author: Jirka Pénzeš
 * Date: 15.2.13
 * Time: 13:58
 */
public class TabPanel extends JComponent {
    private TabTitleControl activeTabTitleControl;

    public TabPanel() {
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(2, 2, 2, 2));
    }

    public void setActiveTabTitleControl(TabTitleControl activeTabTitleControl) {
        this.activeTabTitleControl = activeTabTitleControl;

        removeAll();
        JPanel panelContent = activeTabTitleControl.getPanel();
        panelContent.setSize(getWidth() - 2, getHeight() - 2);
        panelContent.setLocation(1, 1);
        add(panelContent, BorderLayout.CENTER);

        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(new Color(192, 192, 192));
        graphics2D.drawLine(0, 0, 0, getHeight());
        graphics2D.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        graphics2D.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight());

        TabTitleControl tabTitleControl = activeTabTitleControl;
        if (activeTabTitleControl != null) {
            graphics.drawLine(0, 0, tabTitleControl.getX(), 0);
            graphics.drawLine(tabTitleControl.getX() + tabTitleControl.getWidth(), 0, getWidth() - 1, 0);

            graphics.setColor(new Color(231, 231, 231));
            graphics.drawLine(tabTitleControl.getX() + 1, 0, tabTitleControl.getX() + tabTitleControl.getWidth() - 1, 0);
            graphics.drawLine(tabTitleControl.getX() + 1, 1, tabTitleControl.getX() + tabTitleControl.getWidth() - 1, 1);

            // glass effect
            graphics.setColor(new Color(249, 249, 249));
            graphics.drawLine(1, 1, tabTitleControl.getX() + 1, 1);
            graphics.drawLine(tabTitleControl.getX() + tabTitleControl.getWidth() - 1, 1, getWidth() - 2, 1);
            graphics.drawLine(tabTitleControl.getX() + tabTitleControl.getWidth() - 1, 0, tabTitleControl.getX() + tabTitleControl.getWidth() - 1, 1);
            graphics.drawLine(tabTitleControl.getX() + 1, 0, tabTitleControl.getX() + 1, 1);
        }

        // glass effect
        graphics.setColor(new Color(249, 249, 249));
        graphics.drawLine(1, 1, 1, getHeight() - 2);
        graphics.drawLine(1, getHeight() - 2, getWidth() - 2, getHeight() - 2);
        graphics.drawLine(getWidth() - 2, 1, getWidth() - 2, getHeight() - 2);
    }
}

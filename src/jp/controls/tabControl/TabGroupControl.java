package jp.controls.tabControl;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jirka Pénzeš
 * Date: 15.2.13
 * Time: 13:56
 */
public class TabGroupControl extends JComponent {

    private List<TabTitleControl> tabItemsList;
    private TabPanel tabPanel;

    public TabGroupControl(TabPanel tabPanel) {
        tabItemsList = new ArrayList<TabTitleControl>();
        this.tabPanel = tabPanel;
        setBorder(new EmptyBorder(0, 0, 0, 1));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    public void addTabItem(TabItem tabItem) {
        TabTitleControl tabTitleControl = new TabTitleControl(tabItem);

        if (tabItemsList.size() == 0) {
            tabTitleControl = new TabTitleControl(tabItem, true);
            tabPanel.setActiveTabTitleControl(tabTitleControl);
        }

        tabItemsList.add(tabTitleControl);
        add(tabTitleControl);

        tabTitleControl.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                tabItemsMousePressed(mouseEvent);
            }
        });
    }

    private void tabItemsMousePressed(MouseEvent mouseEvent) {
        for (TabTitleControl tabTitleControl : tabItemsList) {
            tabTitleControl.setActive(false);
        }

        TabTitleControl tabTitleControl = ((TabTitleControl) mouseEvent.getSource());
        tabTitleControl.setActive(true);
        tabPanel.setActiveTabTitleControl(tabTitleControl);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(new Color(193, 193, 193));
        graphics2D.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight());
    }
}

package jp.controls.tabControl;

import javax.swing.*;

/**
 * Author: Jirka Pénzeš
 * Date: 15.2.13
 * Time: 13:58
 */
public class TabItem {
    private String name;
    private JPanel panel;

    public TabItem(String name, JPanel panel) {
        this.name = name;
        this.panel = panel;
    }

    public String getName() {
        return name;
    }

    public JPanel getPanel() {
        return panel;
    }
}

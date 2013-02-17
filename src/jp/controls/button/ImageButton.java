package jp.controls.button;

import jp.controls.button.hover.ImageButtonActionStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Author: Jirka Pénzeš
 * Date: 17.2.13
 * Time: 0:55
 */
public class ImageButton extends JComponent {

    private Image image;
    private ImageButtonActionStyle imageButtonActionStyle;
    private int paddingSize;
    private boolean active;

    public ImageButton(Image image) {
        this(image, null);
    }

    public ImageButton(Image image, ImageButtonActionStyle imageButtonActionStyle) {
        this(image, imageButtonActionStyle, new Dimension(10, 10));
    }

    public ImageButton(Image image, ImageButtonActionStyle imageButtonActionStyle, Dimension dimension) {
        this(image, imageButtonActionStyle, dimension, 0);
    }

    public ImageButton(Image image, ImageButtonActionStyle imageButtonActionStyle, Dimension dimension, int paddingSize) {
        this(image, imageButtonActionStyle, dimension, paddingSize, false);
    }

    public ImageButton(Image image, ImageButtonActionStyle imageButtonActionStyle, Dimension dimension, int paddingSize, boolean activeButton) {
        this.image = image;
        this.imageButtonActionStyle = imageButtonActionStyle;
        this.paddingSize = paddingSize;
        this.active = false;

        initialize(dimension, paddingSize);
    }

    private void initialize(Dimension dimension, int paddingSize) {
        Dimension temporaryDimension = new Dimension(dimension.width, dimension.height);
        temporaryDimension.setSize(dimension.width + 2 * paddingSize, dimension.height + 2 * paddingSize);
        setPreferredSize(temporaryDimension);
        setSize(temporaryDimension);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                if (active) return;
                iconLabelMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                iconLabelMouseExited();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                iconLabelMousePressed();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                iconLabelMouseReleased();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }

    public Image getImage() {
        return image;
    }

    public int getPaddingSize() {
        return paddingSize;
    }

    private void iconLabelMouseExited() {
        repaint();
    }

    private void iconLabelMouseEntered() {
        if (imageButtonActionStyle != null)
            imageButtonActionStyle.applyHoverStyle(this);
    }

    private void iconLabelMousePressed() {
        if (imageButtonActionStyle != null)
            imageButtonActionStyle.applyPressedStyle(this);
    }

    private void iconLabelMouseReleased() {
        if (imageButtonActionStyle != null)
            imageButtonActionStyle.applyReleaseStyle(this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (active) {
            graphics.setColor(new Color(199, 199, 199));
            graphics.fillRect(0, 0, getWidth(), getHeight());
            graphics.setColor(new Color(116, 116, 116));
            graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
        graphics.drawImage(image, paddingSize, paddingSize, getWidth() - 2 * paddingSize, getHeight() - 2 * paddingSize, this);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        repaint();
    }
}

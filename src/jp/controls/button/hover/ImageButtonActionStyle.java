package jp.controls.button.hover;

import jp.controls.button.ImageButton;

/**
 * Author: Jirka Pénzeš
 * Date: 17.2.13
 * Time: 0:56
 */
public interface ImageButtonActionStyle {

    public void applyHoverStyle(ImageButton imageButton);

    public void applyPressedStyle(ImageButton imageButton);

    public void applyReleaseStyle(ImageButton imageButton);

}

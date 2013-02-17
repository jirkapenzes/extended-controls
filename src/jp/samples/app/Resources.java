package jp.samples.app;

import java.awt.*;
import java.net.URL;

/**
 * Author: Jirka Pénzeš
 * Date: 17.2.13
 * Time: 1:00
 */
public class Resources {

    private static Resources resource = new Resources();
    private static final String resourceRootDirectory = "/jp/resources/";

    public static Image getImage(String resourceName) {
        URL url = resource.getClass().getResource(resourceRootDirectory + resourceName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

}

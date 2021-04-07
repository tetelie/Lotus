package fr.elie.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ResourceManager {

    private String resourceDir;

    public ResourceManager() {}

    public void setResourceDir(String resourceDir)
    {
        this.resourceDir = resourceDir;
    }

    public URL getFileURL(String fileName)
    {
        return getClass().getResource(resourceDir+fileName);
    }

    public BufferedImage getBufferedImage(String fileName)
    {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getFileURL(fileName));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }

}

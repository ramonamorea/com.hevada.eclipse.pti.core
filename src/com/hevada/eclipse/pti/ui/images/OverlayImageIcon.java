package com.hevada.eclipse.pti.ui.images;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageDataProvider;
import org.eclipse.swt.graphics.Point;

public class OverlayImageIcon extends CompositeImageDescriptor {
  public static final int POS_TOP_LEFT = 0;
  
  public static final int POS_TOP_RIGHT = 1;
  
  public static final int POS_BOTTOM_LEFT = 2;
  
  public static final int POS_BOTTOM_RIGHT = 3;
  
  private final Image baseImage;
  
  private final Image overlayImage;
  
  private final int location;
  
  private final Point sizeOfImage;
  
  public OverlayImageIcon(Image baseImage, Image overlayImage, int location) {
    this.baseImage = baseImage;
    this.overlayImage = overlayImage;
    this.location = location;
    this.sizeOfImage = new Point((baseImage.getBounds()).width, (baseImage.getBounds()).height);
  }
  
  protected void drawCompositeImage(int arg0, int arg1) {
    drawImage((ImageDataProvider)createCachedImageDataProvider(this.baseImage), 0, 0);
    CompositeImageDescriptor.CachedImageDataProvider imageProvider = createCachedImageDataProvider(this.overlayImage);
    switch (this.location) {
      case 0:
        drawImage((ImageDataProvider)imageProvider, 0, 0);
        break;
      case 1:
        drawImage((ImageDataProvider)imageProvider, this.sizeOfImage.x - imageProvider.getWidth(), 0);
        break;
      case 2:
        drawImage((ImageDataProvider)imageProvider, 0, this.sizeOfImage.y - imageProvider.getHeight());
        break;
      case 3:
        drawImage((ImageDataProvider)imageProvider, this.sizeOfImage.x - imageProvider.getWidth(), this.sizeOfImage.y - imageProvider.getHeight());
        break;
    } 
  }
  
  protected Point getSize() {
    return this.sizeOfImage;
  }
  
  public Image getImage() {
    return createImage();
  }
}

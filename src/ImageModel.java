import java.awt.image.BufferedImage;

/*
 * @Function:       ()
 * @Parameters:     Type:
 * @Returns:        NA
 * @Description:
 */

public class ImageModel {

    private BufferedImage view = null;
    private BufferedImage filteredView = null;
    private int width, height;
    //constructor
    public ImageModel(){

    }
    //constructor
    public ImageModel(BufferedImage img){
        this.view = img;
        width = img.getWidth();
        height = img.getHeight();
        this.filteredView = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_INT_RGB);

    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public int getImgWidth(){
        return this.width;
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public int getImgHeight(){
        return this.height;
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void setImgWidth(int w){
        this.width = w;
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void setImgHeight(int h){
        this.height = h;
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void setBuffImg(BufferedImage newImage){
        //error checking
        if(newImage == null) return;
        this.view = newImage;       //sets new image
        this.width = newImage.getWidth();
        this.height = newImage.getHeight();
        this.filteredView = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);

    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public BufferedImage getBuffImg(){
        return this.view;
    }
}

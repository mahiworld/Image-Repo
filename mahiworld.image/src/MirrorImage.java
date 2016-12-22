import java.io.File; //import the File class to read and write image file
import java.io.IOException; //import the IOException class to handle the error (errors may occur due to read/write operation)
import java.awt.image.BufferedImage; //import the BufferedImage class bcoz to hold the image we create BufferedImage object
import javax.imageio.ImageIO; //import the ImageIO class To perform the image read/write operation
public class MirrorImage {
	  public static void main(String args[])throws IOException{
		    //BufferedImage for source image
		    BufferedImage simg = null;
		    //File object
		    File f = null;
		    //read source image file
		    try{
		      f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\images\\kristi.jpg");
		      simg = ImageIO.read(f);
		      System.out.println("Reading completed");
		    }catch(IOException e){
		      System.out.println("Error: " + e);
		    }
		    //get source image dimension
		    int width = simg.getWidth();
		    int height = simg.getHeight();
		    //BufferedImage for mirror image
		    BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
		    //create mirror image pixel by pixel
		    for(int y = 0; y < height; y++){
		      for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
		        //lx starts from the left side of the image
		        //rx starts from the right side of the image
		        //get source pixel value
		        int p = simg.getRGB(lx, y);
		        //set mirror image pixel value - both left and right
		        mimg.setRGB(lx, y, p);
		        mimg.setRGB(rx, y, p);
		      }
		    }
		    //save mirror image
		    try{
		      f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\images\\output\\kristi.jpg");
		      ImageIO.write(mimg, "png", f);
		      System.out.println("Writting completed");
		    }catch(IOException e){
		      System.out.println("Error: " + e);
		    }
		  }//main() ends here
		}//class ends here


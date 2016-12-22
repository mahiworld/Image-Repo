/*
 * Read a image and write the image using getRGB() and setRGB() 
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GetSetPixels {
	public static void main(String...args)throws IOException{
		BufferedImage img = null;
		File f = null;
		
		//read image
		try{
			f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\data\\downey.jpg");
			img = ImageIO.read(f);
			System.out.println("Reading complete.");
		}catch(IOException e){
			System.out.println("Error: "+e);
		}
		
		//get image dimensions
		int width = img.getWidth();
		int height = img.getHeight();
		
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
		//get the pixel value
		int p = img.getRGB(x,y);
		
		//get ARGB values of the pixels
		int a = (p>>24) & 0xff;
		int r = (p>>16) & 0xff;
		int g = (p>>8) & 0xff;
		int b = p & 0xff;
		
		//set the pixel value
	    p  = (a<<24) | (r<<16) | (g<<8) | b;
	    img.setRGB(x,y,p);
			}
		}
	    
	    //write image
	    try{
	    	f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\data\\output\\downey.jpg");
	    	ImageIO.write(img,"jpg",f);
	    	System.out.println("Write complete.");
	    }catch(IOException e){
	    	System.out.println("Error: "+e);
	    }
	}//main() ends here
}//class ends here

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/*
 * program to form negative of input image.
 */
public class Negative {
	public static void main(String...args)throws IOException{
		BufferedImage img = null;
		File f = null;
		
		//read image
		try{
			f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\data\\kristi1.jpg");
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
		
		//subtract RGB from 255
		//We don't have to change the alpha value because it only controls the transparency of the pixel.
		r = 255-r;
		g = 255-g;
		b = 255-b;
		
		//set the pixel value
	    p  = (a<<24) | (r<<16) | (g<<8) | b;
	    img.setRGB(x,y,p);
			}
		}
	    
	    //write image
	    try{
	    	f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\data\\output\\kristi1.jpg");
	    	ImageIO.write(img,"jpg",f);
	    	System.out.println("Write complete.");
	    }catch(IOException e){
	    	System.out.println("Error: "+e);
	    }
	}//main() ends here
}//class ends here

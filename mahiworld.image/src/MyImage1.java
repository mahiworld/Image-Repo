import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 * image reading and writing.
 * get red,green and blue using Color class.
 * and get them to write image.
 */

public class MyImage1 {
	 public static void main(String[] args)  {
		 //image1 start
		 
		 //read image1
		 File f1=null;
		 BufferedImage img1 = null;
		 try{
				f1 = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\images\\tom.jpg");
				img1 = ImageIO.read(f1);
				System.out.println("image1 reading complete.");
			}catch(IOException e){
				System.out.println("Error: "+e);
			}
		 
		 //get image dimention
		    int width1 = img1.getWidth();
			int height1 = img1.getHeight();
			System.out.println(width1 +"  "+ height1);
			
		    BufferedImage DisplayImg1 = new BufferedImage(width1,height1, BufferedImage.TYPE_INT_RGB);
			double pixel1[][]=new double[height1][width1];
			for(int i=0;i<height1;i++)
	    	{
	    		for(int j=0;j<width1;j++)
	    		{	
	    			Color c = new Color(img1.getRGB(j, i));
					int red=(int)c.getRed();
					int green=(int)c.getGreen();
					int blue=(int)c.getBlue();
					
					int avg1= (red+blue+green)/3;
					pixel1[i][j]=avg1;
					Color newC = new Color(avg1,avg1,avg1);
					DisplayImg1.setRGB(j,i,newC.getRGB());
					
	    		}
	    	}
			// write image1
			 try{
			    	f1 = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\images\\output\\tom.jpg");
			    	ImageIO.write(img1,"jpg",f1);
			    	System.out.println("image1 writing complete.");
			    }catch(IOException e){
			    	System.out.println("Error: "+e);
			    }
			 
			 //image1 end
	 }	

}

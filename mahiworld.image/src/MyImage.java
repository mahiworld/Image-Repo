
/** @author: Mahendra
  * @email : mahendrachaudharycr7@gmail.com 
  */
/*
 * reading a image and write the image using BufferedImage class
 */
import java.io.File; //import the File class to read and write image file
import java.io.IOException; //import the IOException class to handle the error (errors may occur due to read/write operation)
import java.awt.image.BufferedImage; //import the BufferedImage class bcoz to hold the image we create BufferedImage object
import javax.imageio.ImageIO; //import the ImageIO class To perform the image read/write operation

//creating MyImage classs
// Since file name is MyImage.java so,class must have the name MyImage
public class MyImage{
	//main method
	//since we are going to perform I/O operations so,we have to add the throws IOException right next to the main() function.
	public static void main(String args[])throws IOException{
		//variables
		int width = 1440; //width of the image
		int height = 1280; //height of the image
		BufferedImage image = null;
		File f = null;
		
		//read image
		//while performing read/write operation it is always suggested to use the try-catch block.
		//This is because I/O operation can generate exception (error) and to take care of that IO exception we need a exception handling code.
		//If we don't use the try-catch block then our code will simply crash when an exception will occur.
		try{
			f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\data\\head_phone.jpg"); //image file path
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); //create an object of BufferedImage type and pass as parameter the width, height and image int type.
			                                                                       //TYPE_INT_ARGB means that we are representing the Alpha, Red, Green and Blue component of the image pixel using 8 bit integer value.
			image = ImageIO.read(f);//read the image using the function read() of the ImageIO class and pass as parameter the image file path which we have stored in variable f.
			System.out.println("Reading complete.");
			}catch(IOException e){
				System.out.println("Error: "+e); //output the error msg
			}
		//write image
	    try{
	      f = new File("C:\\Users\\mahi\\git\\Image-Repo\\mahiworld.image\\data\\Output\\head_phone.jpg");  //output file path
	      ImageIO.write(image, "jpg", f); //write the image using the write() function of the ImageIO class
	      System.out.println("Writing complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e); //output the error message
	    }
	}//main() ends here
}//class ends here
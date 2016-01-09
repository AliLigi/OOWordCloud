package ie.gmit.sw;

import java.io.File;

public class Runner{

	public static void main(String[] args) throws Exception 
	{
		//when you run the runner the image will be created
		//the words in the image over write each other 
		//i did not know how to fix this error 
		
		WordStopList stopWords = new WordStopList("stopwords.txt");
		Parsable toParse = new Parser("warandpeace.txt", stopWords, 60);	
		System.out.println("Finished-- You can check the image.png!! ");
		
	}
}

package ie.gmit.sw;
import java.io.*;
import java.util.*;
public class WordStopList implements Parsable {

		private HashSet<String> stopTheWords;
		
		public WordStopList(String filename) throws Exception
		{
			stopTheWords = new HashSet<String>();
			parse(filename);
		}
		public void parse(String filename) throws Exception 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			StringBuffer sb = new StringBuffer();
			
			int i;
			while((i = br.read()) != -1)
			{
				char next = (char)i;
				
				if (next != '\n') sb.append(next);
				
				else 
				{
					String sWord = sb.toString().toUpperCase();
					sb = new StringBuffer();	
					stopTheWords.add(sWord);
				}
			}
			br.close();
		}
		public boolean hasTheWord(String word)
		{
			boolean isThere = false;
			if(stopTheWords.contains(word))
			{
				isThere = true;
			}
			return isThere;
		}
	}


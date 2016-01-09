package ie.gmit.sw;
import java.util.*;
import java.io.*;

public class Parser implements Parsable {

	private Map<String, Integer> Map = new HashMap<String, Integer>();
	private WordStopList w;
	private WordCloud imgs;
	private int maximumWords;

		
	public Parser(String filename, WordStopList wsl, int max) throws Exception
	{
		w = wsl;	
		parse(filename);
		this.maximumWords = max;
		imgs = new WordCloud(getMap(), maximumWords);
		imgs.drawImage();
	}
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		//1.got this from the Quadgram--from distributed system and changed it to fit this project
		//1.read until the reaching the end of the file
		//2.adding the words to a map if they're not a stop word
		//3.returning the map 
		int j;
		//1
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z' || next == '\'')
			{
				sb.append(next);
			}	
			else 
			{
				String word = sb.toString().toUpperCase();
				sb = new StringBuffer();
				
				//2
				if (!w.hasTheWord(word)&& word.length() > 1) 
				{
					int frequency = 0;
					if(Map.containsKey(word))
					{
						frequency = Map.get(word);
					}
					frequency++;
					Map.put(word, frequency);
					//System.out.println(word + " : " + frequency);
				}
			}
		}
		br.close();		
	}
	//3
	public Map<String, Integer> getMap()
	{
		return Map;
	}
}



package ie.gmit.sw;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

public class WordCloud {

		private Map<String, Integer> map;
		private int maximumWords;
		private Set<Integer> randNum = new HashSet<Integer>();
		
		public WordCloud(Map<String, Integer> map, int max) throws Exception
		{
			this.maximumWords = max;
			this.map = map;
		}
		public void drawImage() throws Exception
		{
			BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_4BYTE_ABGR);
			Graphics graphics = image.getGraphics();
			int i = 0;
			int fontSize = 10;
			int xpoition = 500;
			int yposition = 500 ;
			
			for(String word : map.keySet())
			{  
				randNum.add(xpoition);
				randNum.add(yposition);
				
				//adding texture and style to random numbers pulled from the map
				if(map.get(word) <= 1 == false)
				{
					i++;
					System.out.println(map.get(word));
					
					Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize + map.get(word));
					if(map.get(word) <= 5)
					{
						graphics.setColor(Color.red);
					}
					else if(map.get(word) > 5 && map.get(word) <= 20)
					{
						graphics.setColor(Color.green);
					}
					else if(map.get(word) > 20 && map.get(word) <= 50)
					{
						graphics.setColor(Color.ORANGE);
					}
					else if(map.get(word) > 50 && map.get(word) <= 70)
					{
						graphics.setColor(Color.blue);
					}
					else
					{
						graphics.setColor(Color.yellow);
					}
					do
					{
						xpoition = (int)(Math.random()*901);
					    yposition = (int)(Math.random()*901);
					}while(!(randNum.contains(xpoition) || randNum.contains(yposition)));
					
					graphics.setFont(font);
					graphics.drawString(word, xpoition, yposition);
					
					if(i == maximumWords)
					{
						break;
					}
				}
			}
			//writing the words to the image
			graphics.dispose();
			ImageIO.write(image, "png", new File("image.png"));
		}
	}


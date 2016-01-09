package ie.gmit.tests;

import org.junit.*;
import ie.gmit.sw.*;
import static org.junit.Assert.*;

public class JunitTesting {

	//J unit testing --tests the WordStopList,Parser, WordCloud 
	private Parser testparse;
	private WordStopList stopwords;
	@Before
	@After
	public void destroyMap()
	{
		testparse = null;
	}
	
	@Test 
	public void validFile() throws Exception
	{
		stopwords = new WordStopList("stopwords.txt");
		testparse = new Parser("./warandpeace.txt", stopwords, 3);
	}
	@Test
	public void inValidFile() throws Exception
	{
		stopwords = new WordStopList("stopwords.txt");
		testparse = new Parser("./warandpeace.txt", stopwords,3);
	}
	@Test
	public void invalidStopwords() throws Exception
	{
		stopwords = new WordStopList("stops.txt");
	}
	@Test
	public void validWordCloud() throws Exception
	{
		stopwords = new WordStopList("stopwords.txt");
		testparse = new Parser("./warandpeace.txt", stopwords,3);
		WordCloud img = new WordCloud(testparse.getMap(), 80);
	}
	@Test
	public void invalidWordCloud() throws Exception
	{
		stopwords = new WordStopList("stopwords.txt");
		testparse = new Parser("./warandpeace.txt", stopwords,3);
		WordCloud img = new WordCloud(testparse.getMap(), 80);
	}

	
}

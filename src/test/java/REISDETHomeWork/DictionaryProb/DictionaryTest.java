package REISDETHomeWork.DictionaryProb;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

	@Test
	public void test_wordsearch() {
		String input="homework";
		Dictionary d1= Dictionary.get();
	    List<String> output=d1.findmatch(input);
	    Assert.assertEquals(true, output.contains("home"));
	    Assert.assertEquals(203, output.size());
	}
	
	@Test
	public void test_isEnglishword() {
		Dictionary d1 = Dictionary.get();
		Assert.assertTrue(d1.isEnglishWord("working", "work"));
		Assert.assertTrue(d1.isEnglishWord("working", "row"));
		Assert.assertTrue(d1.isEnglishWord("working", "ring"));
		Assert.assertTrue(d1.isEnglishWord("working", "king"));
	}
}

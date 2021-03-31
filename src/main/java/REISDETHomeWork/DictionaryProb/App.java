package REISDETHomeWork.DictionaryProb;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// string to search
		String s = "homework";

		Dictionary b1 = Dictionary.get();
		List<String> result = b1.findmatch(s);
		// print the result
		System.out.println(result);
		System.out.println("Number of matching words: "+result.size());
	}
}

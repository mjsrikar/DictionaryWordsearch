package REISDETHomeWork.DictionaryProb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Dictionary {
	public static Set<String> dictionary;
	private static Dictionary instance = new Dictionary();

	static {
		dictionary = new HashSet<String>();
		List<String> list = new ArrayList<>();
		try {

			File file = new File(System.getProperty("user.dir")
					+ "\\src\\main\\java\\REISDETHomeWork\\DictionaryProb\\database2.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dictionary = list.stream().map(s -> s.toLowerCase()).filter(s -> s.chars().allMatch(Character::isLetter))
				.collect(Collectors.toSet());
	}

	private Dictionary() {

	}

	public static Dictionary get() {
		return instance;
	}

	// count of occurrence of the characters in the given String
	private int[] scount(String s) {
		int[] occurance = new int[26];
		for (char c : s.toCharArray()) {
			int alphabet_pos = c - 'a';
			if (alphabet_pos >= 0 && alphabet_pos < 26) {
				occurance[alphabet_pos]++;
			}
		}
		return occurance;
	}

	// return FALSE if the input string is not found in dictionary
	public boolean isEnglishWord(String input, String dictionaryWord) {
		int[] occurance = scount(input);
		int[] dict = scount(dictionaryWord);
		for (int i = 0; i < 26; i++) {
			if (occurance[i] == 0 && dict[i] > 0) {
				return false;
			} else if (occurance[i] < dict[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * searches the input word in the dictionary for the matching words based on search criteria. 
	 * @param input 
	 * @return list of words found in the dictionary. Returns empty list if the input is null or empty or has special characters 
	 */
	public List<String> findmatch(String input) {
		List<String> output = new ArrayList<String>();
		
		if(input != null && !input.isEmpty()) {
			
			for(char ch : input.toCharArray()) {
				if(!Character.isLetter(ch)) {
					System.out.println("Found a special character, cannot process a special character");
					return output;					
				}
			}
			
			for (String str : dictionary) {
				if (isEnglishWord(input, str)) {
					output.add(str);
				}
			}
		}else {
			System.out.println("Input is either null or empty");
		}
		return output;
	}

}

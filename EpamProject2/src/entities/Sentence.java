package entities;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

	private List<Word> words;

	private Sentence(List<Word> words) {
		this.words = words;
	}

	// Separate object creation logic, from constructing. Due to Joshua Bloch
	// "Effective Java" Rule 1
	//Converting String to the List of Word objects
	public static Sentence getSentence(String sentence) {
		String[] wordsArray = sentence.split("\\p{Punct}\\s+|\\s+");
		List<Word> words = new ArrayList<Word>();
		for (String s : wordsArray) {
			words.add(Word.getWord(s));
		}
		return new Sentence(words);
	}

	public int getWordsQuantity() {
		return words.size();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Word w : words) {
			str.append(w.toString().concat(" "));
		}
		return str.toString();
	}

}

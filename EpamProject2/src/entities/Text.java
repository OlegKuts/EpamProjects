package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Text {
	private List<Sentence> sentences;

	private Text(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	// Separate object creation logic, from constructing. Due to Joshua Bloch
	// "Effective Java" Rule 1
	// Here open a text file and parse all Strings into Sentence objects,
	// and store it in the List
	public static Text getText(String filePath) {
		List<Sentence> sentences = new ArrayList<Sentence>();
		try (BufferedReader reader = new BufferedReader(
				new FileReader(filePath))) {
			StringBuilder textBuilder = new StringBuilder();
			String text = "";
			while (reader.ready()) {
				textBuilder.append(reader.readLine().replaceAll("\\s+", " "));
			}
			text = textBuilder.toString();
			String[] sentencesArray = text.split("(\\.|\\?|\\!|\\.\\.\\.)\\s+");
			for (String s : sentencesArray) {
				sentences.add(Sentence.getSentence(s));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new Text(sentences);
	}

	public void show() {
		for (Sentence s : sentences) {
			System.out.println(s);
		}
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public static Text sort(Text text) {
		List<Sentence> sorted = new ArrayList<Sentence>(text.getSentences());
		Collections.sort(sorted, new Comparator<Sentence>() {

			@Override
			public int compare(Sentence o1, Sentence o2) {
				return o1.getWordsQuantity() - o2.getWordsQuantity();
			}
		});

		return new Text(sorted);
	}
}

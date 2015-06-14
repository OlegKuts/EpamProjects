package entities;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private List<Symbol> symbols;

	private Word(List<Symbol> symbols) {
		this.symbols = symbols;
	}

	// Separate object creation logic, from constructing. Due to Joshua Bloch
	// "Effective Java" Rule 1
	//Converting String to the List of Symbol objects
	public static Word getWord(String word) {
		char[] chars = word.toCharArray();
		List<Symbol> symbols = new ArrayList<Symbol>();
		for (char ch : chars) {
			symbols.add(Symbol.getSymbol(ch));
		}
		return new Word(symbols);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Symbol s : symbols) {
			str.append(s.getCharacter());
		}
		return str.toString();
	}

}

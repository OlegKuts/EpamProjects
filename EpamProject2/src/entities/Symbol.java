package entities;

import java.util.HashMap;

import java.util.Map;

public class Symbol {
	private char character;
	//Implementation of Flyweight pattern. Is is needed to prevent program from duplicating Symbol's instances
	private static Map<Character, Symbol> symbols = new HashMap<Character, Symbol>();

	private Symbol(char character) {
		this.character = character;
		symbols.put(character, this);
	}

	public static Symbol getSymbol(char c) {
		return symbols.getOrDefault(c, new Symbol(c));
	}

	public char getCharacter() {
		return character;
	}
}

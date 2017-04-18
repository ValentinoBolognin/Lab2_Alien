package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		this.translations = new ArrayList<String>();
	}
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations = new ArrayList<String>();
		this.translations.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public List<String> getTranslations() {
		return translations;
	}

	public void setTranslations(String translation) {
		if(!this.translations.contains(translation))
			this.translations.add(translation);
	}
	
	public boolean compare(String alienWord){
		if(this.alienWord.equals(alienWord))
			return true;
		else
			return false;
	}

}

package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> dictionary;
	
	public AlienDictionary() {
		dictionary = new ArrayList<WordEnhanced>();
	}

	public void addWordEnhanced(String alienWord, String translation){
		for(WordEnhanced temp : dictionary){
			if(temp.compare(alienWord)){
				temp.setTranslations(translation);
				return;
			}
		}
		WordEnhanced w = new WordEnhanced(alienWord, translation);
		dictionary.add(w);
	}
	
	public List<String> translateWordEnhanced(String alienWord){
		for(WordEnhanced temp : dictionary){
			if(temp.compare(alienWord))
				return temp.getTranslations();
		}
		return null;
	}

}

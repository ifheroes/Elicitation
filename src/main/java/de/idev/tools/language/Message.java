package de.idev.tools.language;

import java.util.EnumMap;
import java.util.Map;

/*
 * Representing each message with it's proper translation
 */
public enum Message {

	NOPERMISSION;
	
	Map<Language, String> messages = new EnumMap<>(Language.class);
	
	/*
	 * Sets the text in a given language
	 * 
	 * @param language is the key for the text
	 * @param text is the value of the key
	 */
	public void setText(Language language, String text) {
		messages.put(language, text);
	}
	
	/*
	 * gets the text in a specified language
	 * 
	 * @param language is the key to the Text
	 */
	public String getText(Language language) {
		if(!messages.containsKey(language)) return this.name()+" <- has not been set!";
		return messages.get(language);
	}
}

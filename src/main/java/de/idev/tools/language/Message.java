package de.idev.tools.language;

import java.util.EnumMap;
import java.util.Map;

import net.md_5.bungee.api.ChatColor;

/*
 * Representing each message with it's proper translation
 */
public enum Message {

	NOPERMISSION, JOINMESSAGE;
	
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
		if(!messages.containsKey(language)) return ChatColor.RED + this.name()+" <- has not been set in this language!";
		return messages.get(language);
	}
}

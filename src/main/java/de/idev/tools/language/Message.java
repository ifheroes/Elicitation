package de.idev.tools.language;

import java.util.EnumMap;
import java.util.Map;

public enum Message {

	NOPERMISSION;
	
	Map<Language, String> messages = new EnumMap<>(Language.class);
	
	public void setText(Language language, String text) {
		messages.put(language, text);
	}
	
	public String getText(Language language) {
		if(!messages.containsKey(language)) return this.name()+" <- has not been set!";
		return messages.get(language);
	}
}

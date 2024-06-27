package de.idev.tools.language;

/*
 * This enumeration delineates the currently supported languages
 * Each enumeration is assigned a constructor that specifies its full written name
 */
public enum Language {
	GER("German"), EN("English");
	
	private String fullName;
	
	Language(String fullName) {
		this.fullName = fullName;
	}
	
	/*
	 * Return the full name of the Object
	 */
	String getFullName() {
		return this.fullName;
	}
}

package de.idev.tools.language;

public enum Language {
	GER("German"), EN("English");
	
	private String fullName;
	
	Language(String fullName) {
		this.fullName = fullName;
	}
	
	String getFullName() {
		return this.fullName;
	}
}

package de.idev.tools;

import com.google.gson.JsonObject;

public abstract class JsonClass {

	protected JsonClass() {
	}
	
	protected JsonClass(JsonObject jsonObject) {
	}
	
	public abstract JsonObject getAsJson();
	
}

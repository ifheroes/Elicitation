package de.idev.tools;

import com.google.gson.JsonObject;

public abstract class JsonClass {

	public JsonClass() {
	}
	
	public JsonClass(JsonObject jsonObject) {
	}
	
	public abstract JsonObject getAsJson();
	
}

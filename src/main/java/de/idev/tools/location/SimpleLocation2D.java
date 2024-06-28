package de.idev.tools.location;

import com.google.gson.JsonObject;

public class SimpleLocation2D {

	private int x;
	private int z;
	
	public SimpleLocation2D(int x, int z) {
		this.setX(x);
		this.setZ(z);
		
	}

	public SimpleLocation2D(JsonObject obj) {
		this(obj.get("x").getAsInt(), obj.get("z").getAsInt());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public JsonObject getAsJson() {
		JsonObject obj = new JsonObject();
		obj.addProperty("x", getX());
		obj.addProperty("z", getZ());
		return obj;
	}
	
}

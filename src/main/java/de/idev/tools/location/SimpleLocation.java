package de.idev.tools.location;

import com.google.gson.JsonObject;

public class SimpleLocation {

	private int x;
	private int y;
	private int z;
	
	public SimpleLocation(int x, int y, int z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	public SimpleLocation(JsonObject obj) {
		this(obj.get("x").getAsInt(), obj.get("y").getAsInt(), obj.get("z").getAsInt());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		obj.addProperty("y", getY());
		obj.addProperty("z", getZ());
		return obj;
	}
	
}

package de.idev.tools.location;

import com.google.gson.JsonObject;

public class SimpleLocation3D extends SimpleLocation2D{

	private int y;
	
	public SimpleLocation3D(int x, int y,int z) {
		super(x, z);
		this.setY(y);
	}
	
	public SimpleLocation3D(JsonObject obj) {
		super(obj);
		this.setY(obj.get("y").getAsInt());
	}
	
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	@Override
	public JsonObject getAsJson() {
		JsonObject obj = super.getAsJson();
		obj.addProperty("y", getY());
		return obj;
	}
	
}

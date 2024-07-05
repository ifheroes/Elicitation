package de.idev.tools.location;

import com.google.gson.JsonObject;

import de.idev.tools.File;


public class Position {
	
	private static File positionsFile = new File("positions.yml", null);
	private RotationalLocation location;
	private String id;
	
	public Position(RotationalLocation location, String id) {
		setLocation(location);
		setId(id);
	}
	
	//TODO: Get from json
	
	public Position(String id) {
		this(new RotationalLocation(positionsFile.get(id, JsonObject.class)), id);
	}
	
	public void savePosition() {
		positionsFile.set(getId(), getAsJson());
	}
	
	public void setLocation(RotationalLocation location) {
		this.location = location;
	}
	
	public RotationalLocation getLocation() {
		return location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public JsonObject getAsJson() {
		return getLocation().getAsJson();
	}
	
}

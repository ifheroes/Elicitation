package de.idev.tools.location;

import com.google.gson.JsonObject;

public class RotationalLocation extends SimpleLocation{

	private double yaw;
	private double pitch;
	
	public RotationalLocation(JsonObject obj) {
		this(obj.get("x").getAsInt(), obj.get("y").getAsInt(), obj.get("z").getAsInt(), obj.get("yaw").getAsDouble(), obj.get("pitch").getAsDouble());
	}
	public RotationalLocation(int x, int y, int z, double yaw, double pitch) {
		super(x, y, z);
		setYaw(yaw);
		setPitch(pitch);
	}
	
	public double getYaw() {
		return yaw;
	}
	
	public void setYaw(double yaw) {
		this.yaw = yaw;
	}
	
	public double getPitch() {
		return pitch;
	}
	
	public void setPitch(double pitch) {
		this.pitch = pitch;
	}
	
	
	@Override
	public JsonObject getAsJson() {
		JsonObject obj = super.getAsJson();
		obj.addProperty("yaw", getYaw());
		obj.addProperty("pitch", getPitch());
		return obj;
	}
	
}

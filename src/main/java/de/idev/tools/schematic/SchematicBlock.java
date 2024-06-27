package de.idev.tools.schematic;

import org.bukkit.Material;
import org.bukkit.block.Block;

import com.google.gson.JsonObject;

public class SchematicBlock {

	private Material material;
	private String blockData;
	private int x;
	private int y;
	private int z;
	
	public SchematicBlock(Material material, int x, int y, int z, String blockdata) {
		this.setMaterial(material);
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.blockData = blockdata;
		if(this.blockData == null) this.blockData = "";
	}

	public SchematicBlock(Block block) {
		this(block.getType(), block.getX(), block.getY(), block.getZ(), block.getBlockData().getAsString());
	}
	
	public SchematicBlock(JsonObject obj) {
		this.material = Material.valueOf(obj.get("material").getAsString());
		this.blockData = obj.get("data").getAsString();
		this.x = obj.get("x").getAsInt();
		this.y = obj.get("y").getAsInt();
		this.z = obj.get("z").getAsInt();
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
	
	public String getBlockData() {
		return this.blockData;
	}
	
	public JsonObject getAsJson() {
		JsonObject obj = new JsonObject();
		obj.addProperty("material", this.material.toString());
		obj.addProperty("x", this.x);
		obj.addProperty("y", this.y);
		obj.addProperty("z", this.z);
		obj.addProperty("data", this.blockData);
		return obj;
	}
}

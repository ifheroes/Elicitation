package de.idev.tools.schematic;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.idev.tools.schematic.util.SchematicLoader;

public class Schematic extends SchematicLoader{

	private List<SchematicBlock> blocks;
	private String id;
	private SimpleLocation origin;
	
	private static final String ORIGINID = "origin";
	private static final String BLOCKID = "blocks";
	private static final String SCHEMATICID = "id";
	
	public Schematic(String id) {
		this.setBlocks(new ArrayList<>());
		this.id = id;
	}
	
	public Schematic(JsonObject obj) {
		this(obj.get(SCHEMATICID).getAsString());	
		JsonArray array = obj.get(BLOCKID).getAsJsonArray();
		array.forEach(x -> blocks.add(new SchematicBlock(x.getAsJsonObject())));
		if(obj.has(ORIGINID)) this.origin = new SimpleLocation(obj.get(ORIGINID).getAsJsonObject());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SchematicBlock> getBlocks() {
		return blocks;
	}

	public void addBlock(Block b) {
		this.blocks.add(new SchematicBlock(b));
	}
	
	public void setBlocks(List<SchematicBlock> blocks) {
		this.blocks = blocks;
	}

	public SimpleLocation getOrigin() {
		return this.origin;
	}

	public void setOrigin(SimpleLocation origin) {
		this.origin = origin;
		for(SchematicBlock block : this.blocks) {
			block.setX(block.getX()-origin.getX());
			block.setY(block.getY()-origin.getY());
			block.setZ(block.getZ()-origin.getZ());
		}
		
	}
	
	public JsonObject getAsJson() {
		JsonObject obj = new JsonObject();
		obj.addProperty(SCHEMATICID, this.id);
		if(origin != null) obj.add(ORIGINID, origin.getAsJson());
		
		JsonArray objarray = new JsonArray();
		blocks.forEach(x -> objarray.add(x.getAsJson()));
		
		obj.add(BLOCKID, objarray);
		return obj;
	}
}

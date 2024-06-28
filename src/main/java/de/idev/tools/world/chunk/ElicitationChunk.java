package de.idev.tools.world.chunk;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.idev.tools.JsonClass;
import de.idev.tools.location.SimpleLocation2D;

public class ElicitationChunk extends JsonClass{

	private int size;
	private List<ChunkMark> marks;
	private SimpleLocation2D location;
	
	public ElicitationChunk(int size, SimpleLocation2D location) {
		this.size = size;
		this.location = location;
	}

	@Override
	public JsonObject getAsJson() {
		JsonObject json = new JsonObject();
		json.addProperty("size", getSize());
		json.add("location", location.getAsJson());
		
		JsonArray array = new JsonArray();
		marks.forEach(x -> array.add(json));
		
		json.add("marks", array);
		
		return json;	
	}

	public int getSize() {
		return size;
	}

	public List<ChunkMark> getMarks() {
		return marks;
	}

	public void addMarks(ChunkMark marks) {
		this.marks.add(marks);
	}
	public boolean hasMarks(ChunkMark marks) {
		return this.marks.contains(marks);
	}
	public void removeMarks(ChunkMark marks) {
		this.marks.remove(marks);
	}
	
	
}

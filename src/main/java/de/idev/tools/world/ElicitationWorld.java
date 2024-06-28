package de.idev.tools.world;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.google.gson.JsonObject;

import de.idev.tools.File;
import de.idev.tools.JsonClass;
import de.idev.tools.world.chunk.ElicitationChunk;

public class ElicitationWorld extends JsonClass{

	public ElicitationWorld(JsonObject jsonObject) {
		super(jsonObject);
		
	}

	public ElicitationWorld(String bukkitWorldName) {
		this.world = Bukkit.getWorld(bukkitWorldName);
	}


	private static File worldsFile = new File("worlds.yml", null);
	private List<ElicitationChunk> placedChunks;
	private World world;
	
	
	
	@Override
	public JsonObject getAsJson() {
		JsonObject json = new JsonObject();
		
		return json;
	}
}

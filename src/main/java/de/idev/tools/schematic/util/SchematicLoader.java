package de.idev.tools.schematic.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import de.idev.tools.File;
import de.idev.tools.schematic.Schematic;


public class SchematicLoader {

	public static File schematicsave = new File("schematics.yml", null);
	
	public static Schematic loadSchematic(String id) {
		String jsonString = schematicsave.get(id, String.class);
		if(jsonString == null) return null;
		try {
			return new Schematic(JsonParser.parseString(jsonString).getAsJsonObject());
		} catch (JsonSyntaxException ex){
			return new Schematic("");
		}
	}
	
	public static List<String> getSchematics(){
		return new ArrayList<>(schematicsave.getYml().getKeys(false));
	}
}

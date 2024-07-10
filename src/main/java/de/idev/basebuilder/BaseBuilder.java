package de.idev.basebuilder;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BaseBuilder {
	
	/*
	 * Has the list of Players building and their original position
	 */
	private static final Map<Player, Location> playersBuildingBases = new HashMap<>();
	public static final String buildFlagKey = "established";
	
	public static boolean hasBuilder(Player player) {
		return playersBuildingBases.containsKey(player);
	}
	
	public static void addBuilder(Player player, Location location) {
		playersBuildingBases.put(player, location);
	}
	
	public static void removeBuilder(Player player) {
		playersBuildingBases.remove(player);
	}
	
	public static Location getLocation(Player player) {
		return playersBuildingBases.get(player);
	}
	
}

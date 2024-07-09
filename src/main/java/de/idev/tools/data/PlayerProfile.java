package de.idev.tools.data;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class PlayerProfile extends GenericDataStorage{

	private static class DataKey {
		public static final String LEVEL = "level";
	}
	
	private UUID uuid;
	
	
	public PlayerProfile(Player player) {
		super(player);
		this.uuid = player.getUniqueId();
	}

	public int getLevel() {
		return get(DataKey.LEVEL, PersistentDataType.INTEGER);
	}
	
	public void setLevel(int level) {
		set(DataKey.LEVEL, PersistentDataType.INTEGER, level);
	}
	
	public UUID getUUID() {
		return this.uuid;
	}
	
}

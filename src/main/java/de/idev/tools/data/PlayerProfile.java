package de.idev.tools.data;

import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import de.idev.tools.language.Language;

public class PlayerProfile extends GenericDataStorage{

	private static class DataKey {
		public static final String LEVEL = "level";
		public static final String LANGUAGE = "LANGUAGE";
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
	
	public Language getLanguage() {
		try {
			return Language.valueOf(get(DataKey.LANGUAGE, PersistentDataType.STRING));
		} catch (NullPointerException exception) {
			Bukkit.getLogger().log(Level.WARNING, "PlayerProfile: Language of profile "+getUUID().toString()+ " has not been found!");
			return Language.EN;
		}
	}
	
	public void setLanguage(Language language) {
		set(DataKey.LANGUAGE, PersistentDataType.STRING, language.toString());
	}
	
	public UUID getUUID() {
		return this.uuid;
	}
	
}

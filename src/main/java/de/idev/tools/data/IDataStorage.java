package de.idev.tools.data;

import javax.annotation.Nonnull;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.idev.ElicitationPlugin;

/*
 * A generic interface to modify the PersistantDataContainer(Bukkit) in a more organized and easy manor
 */
public interface IDataStorage {
	
	Plugin plugin = JavaPlugin.getPlugin(ElicitationPlugin.class);
	
	/*
	 * Look up Bukkit PersistantDataContainer for clarification
	 * 
	 * @param key = The key a value will be stored under
	 * @param P = Type of the value that will be stored
	 * @param C = The Value with the type P that will be stored
	 *
	 */
    <P, C> void set(@Nonnull String key,@Nonnull PersistentDataType<P, C> type,@Nonnull C value);
    <P, C> C get(@Nonnull String key,@Nonnull PersistentDataType<P, C> type);
    boolean has(@Nonnull String key);
    <T extends PersistentDataHolder> PersistentDataContainer getDataContainer(T something);
}

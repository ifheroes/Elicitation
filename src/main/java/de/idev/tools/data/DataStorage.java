package de.idev.tools.data;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;

public abstract class DataStorage implements IDataStorage{
	
	PersistentDataHolder holder;
	
	protected <T extends PersistentDataHolder> DataStorage(T persistentDataHolder) {
		this.holder = persistentDataHolder;
	}
	
	@Override
	public boolean has(String key) {
		return getDataContainer(holder).has(new NamespacedKey(plugin, key));
	}
	
	@Override
	public <P, C> void set(String key, PersistentDataType<P, C> type, C value) {
		getDataContainer(holder).set(new NamespacedKey(plugin, key), type, value);
	}
	
	@Override
	public <P, C> C get(String key, PersistentDataType<P, C> type) {
		return getDataContainer(holder).get(new NamespacedKey(plugin, key), type);
	}
	
	@Override
	public <T extends PersistentDataHolder> PersistentDataContainer getDataContainer(T persistentDataHolder) {
		return persistentDataHolder.getPersistentDataContainer();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PersistentDataHolder> T getHolder() {
		return (T) holder;
	}
}

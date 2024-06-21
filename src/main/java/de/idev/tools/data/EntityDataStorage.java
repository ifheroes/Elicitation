package de.idev.tools.data;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class EntityDataStorage implements IDataStorage{

	private Entity entity;
	
	EntityDataStorage(Entity entity) {
		this.entity = entity;
	}
	
	public <P, C> void set(String key, PersistentDataType<P, C> type, C value) {
		getDataContainer(entity).set(new NamespacedKey(plugin, key), type, value);
	}
	
	public <P, C> C get(String key, PersistentDataType<P, C> type) {
		return getDataContainer(entity).get(new NamespacedKey(plugin, key), type);
	}
	
	PersistentDataContainer getDataContainer(Entity entity) {
		return entity.getPersistentDataContainer();
	}
}

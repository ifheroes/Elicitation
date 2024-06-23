package de.idev.tools.data;

import org.bukkit.persistence.PersistentDataHolder;

public class GenericDataStorage extends DataStorage{
	public <T extends PersistentDataHolder> GenericDataStorage(T persistentDataHolder) {
		super(persistentDataHolder);
	}
}

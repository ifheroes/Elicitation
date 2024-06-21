package de.idev.tools.data;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ItemDataStorage implements IDataStorage {

	private ItemStack item;

	public ItemDataStorage(ItemStack item) {
		this.item = item;
	}

	@Override
	public <P, C> void set(String key, PersistentDataType<P, C> type, C value) {
		ItemMeta meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(new NamespacedKey(plugin, key), type, value);
		item.setItemMeta(meta);
	}

	@Override
	public <P, C> C get(String key, PersistentDataType<P, C> type) {
		return item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, key), type);
	}

}

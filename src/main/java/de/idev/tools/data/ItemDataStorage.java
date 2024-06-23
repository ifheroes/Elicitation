package de.idev.tools.data;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class ItemDataStorage extends DataStorage {
	
	private ItemStack itemStack;
	
	public ItemDataStorage(ItemStack itemStack) {
		super(itemStack.getItemMeta());
		setItemStack(itemStack);
	}

	@Override
	public <P, C> void set(String key, PersistentDataType<P, C> type, C value) {
		super.set(key, type, value);
		itemStack.setItemMeta(getHolder());
	}

	public ItemStack getItemStack() {
		return itemStack;
	}
	
	private void setItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}
	
}

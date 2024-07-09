package de.idev;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.idev.bukkitevents.ElicitationEntityDamageEntityEvent;
import de.idev.bukkitevents.ElicitationPlayerJoinEvent;
import de.idev.tools.damagevisual.DamageVisualAPI;

public class ElicitationPlugin extends JavaPlugin{
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		loadMessages();
		
		registerEvents();
		registerCommands();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	private void registerEvents() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		
		pluginManager.registerEvents(new ElicitationEntityDamageEntityEvent(new DamageVisualAPI()), this);
		pluginManager.registerEvents(new ElicitationPlayerJoinEvent(), this);
	}
	
	private void registerCommands() {
		
	}
	
	private void loadMessages() {
		
	}
	
	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}
}

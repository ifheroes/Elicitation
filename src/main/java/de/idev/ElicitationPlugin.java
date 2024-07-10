package de.idev;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.idev.basebuilder.commands.BaseBuilderCommand;
import de.idev.basebuilder.events.ElicitationPlayerMoveEvent;
import de.idev.basebuilder.events.ElicitationPlayerInteractEvent;
import de.idev.damageindicator.DamageVisualAPI;
import de.idev.damageindicator.events.ElicitationEntityDamageEntityEvent;
import de.idev.events.ElicitationPlayerJoinEvent;

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
		
		/*
		 * Base Builder
		 */
		pluginManager.registerEvents(new ElicitationPlayerMoveEvent(), this);
		pluginManager.registerEvents(new ElicitationPlayerInteractEvent(), this);
	}
	
	private void registerCommands() {
		/*
		 * Base Builder
		 */
		getCommand("gbuild").setExecutor(new BaseBuilderCommand());
	}
	
	private void loadMessages() {
		
	}
	
	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}
}

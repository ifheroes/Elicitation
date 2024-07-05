package de.idev;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.idev.bukkitevents.ElicitationEntityDamageEntityEvent;
import de.idev.tools.damagestats.DamageStatsAPI;

public class ElicitationPlugin extends JavaPlugin{
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		registerEvents();
		registerCommands();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	private void registerEvents() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		
		pluginManager.registerEvents(new ElicitationEntityDamageEntityEvent(new DamageStatsAPI()), this);
	}
	
	private void registerCommands() {
		
	}
	
	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}
	
}

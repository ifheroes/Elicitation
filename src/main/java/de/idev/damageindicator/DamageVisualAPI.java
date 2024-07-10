package de.idev.damageindicator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TextDisplay;
import org.bukkit.plugin.java.JavaPlugin;

import de.idev.ElicitationPlugin;

public class DamageVisualAPI {

	public Entity createDisplayText(Location loc, String text) {
		return loc.getWorld().spawn(loc, TextDisplay.class, entity -> {
			entity.setCustomName(text);
			entity.setCustomNameVisible(true);
			entity.setSeeThrough(true);
		});
	}
	
	public void createDisplayText(Location loc, String text, long ticks) {
		Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(ElicitationPlugin.class), createDisplayText(loc, text)::remove, ticks);
	}
	
	public double normalizedDouble(double value) {
		double scale = Math.pow(10, 2);
		return Math.round(value * scale) / scale;
	}
}

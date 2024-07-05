package de.idev.bukkitevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.idev.ElicitationPlugin;
import de.idev.tools.damagestats.DamageStatsAPI;
import de.idev.tools.events.DisplayDamageEvent;

public class ElicitationEntityDamageEntityEvent implements Listener{
	
	private DamageStatsAPI api;
	
	public ElicitationEntityDamageEntityEvent(DamageStatsAPI api) {
		this.api = api;
	}
	
	
	@EventHandler
	public void entityDamageEntity(EntityDamageByEntityEvent event) {
		Entity target = event.getEntity();
		Entity damager = event.getDamager();
		if(!(target instanceof LivingEntity)) return;
		
		DisplayDamageEvent displayDamageEvent = new DisplayDamageEvent(event.getDamage(), target.getLocation(), target, damager, 2*20L);
		ElicitationPlugin.callEvent(displayDamageEvent);
		if(displayDamageEvent.isCancelled()) return;
		
		api.createDisplayText(displayDamageEvent.getLocation(), displayDamageEvent.getText(), displayDamageEvent.getTime());
	}
	
	public DamageStatsAPI getDamageStatsAPI() {
		return this.api;
	}
	
}

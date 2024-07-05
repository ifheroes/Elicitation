package de.idev.tools.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DisplayDamageEvent extends Event implements Cancellable {

	private static final HandlerList HANDLERS_LIST = new HandlerList();
	
	private boolean isCancelled;
	private double damage;
	private Location location;
	private String text;
	private Entity target;
	private Entity damager;
	private long time;
	private double hightAboveEntity;
	
	private int decimalPlaces = 2;
	
	
	public DisplayDamageEvent(double damage, Location location, Entity target, Entity damager, long time) {
		setDamage(damage);
		setCancelled(false);
		setText(ChatColor.RED+""+this.getNormalizedDamage());
		this.target = target;
		this.damager = damager;
		setTime(time);
		
		setHightAboveEntity(0.8); // -> Default
		setLocation(location.add(0, target.getHeight()+getHightAboveEntity(), 0));
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS_LIST;
	}

	public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
	
	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		this.isCancelled = arg0;
	}

	public double getAbsoluteDamage() {
		return damage;
	}

	public double getNormalizedDamage() {
		double scale = Math.pow(10, decimalPlaces);
		return Math.round(this.damage * scale) / scale;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Entity getTarget() {
		return target;
	}

	public Entity getDamager() {
		return damager;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getHightAboveEntity() {
		return hightAboveEntity;
	}

	public void setHightAboveEntity(double hightAboveEntity) {
		this.hightAboveEntity = hightAboveEntity;
	}

}

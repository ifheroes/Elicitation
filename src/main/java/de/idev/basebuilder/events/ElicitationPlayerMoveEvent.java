package de.idev.basebuilder.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.idev.basebuilder.BaseBuilder;
import de.idev.tools.math.LinearFunction;

/*
 * Based on the height of the player he will gain a higher speed
 */

public class ElicitationPlayerMoveEvent implements Listener{
	
	@EventHandler
	public void a(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(!BaseBuilder.hasBuilder(p)) return;
		Location location = e.getTo();
		LinearFunction lf = new LinearFunction((1/80.1)/2, 0.1);
		float speed = lf.f(location.getY());
		
		p.setFlySpeed(speed);
	}
	
}

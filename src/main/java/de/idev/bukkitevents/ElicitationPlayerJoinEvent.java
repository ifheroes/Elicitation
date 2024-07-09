package de.idev.bukkitevents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.idev.tools.data.PlayerProfile;
import de.idev.tools.language.Message;

public class ElicitationPlayerJoinEvent implements Listener{

	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event) {
		/*
		 * On every join
		 */
		sendJoinMessage(event.getPlayer());
		
		/*
		 * On first join
		 */
		if(event.getPlayer().hasPlayedBefore()) return;
		
		
	}
	
	public void sendJoinMessage(Player player) {
		PlayerProfile playerProfile = new PlayerProfile(player);
		player.sendMessage(Message.JOINMESSAGE.getText(playerProfile.getLanguage()));
	}
	
	
}

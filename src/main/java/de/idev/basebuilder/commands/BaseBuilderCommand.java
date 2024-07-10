package de.idev.basebuilder.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.idev.basebuilder.BaseBuilder;
import de.idev.tools.language.Language;
import de.idev.tools.language.Message;

/*
 * This class is temporary and represents the activity to get into the base building mode
 */

public class BaseBuilderCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Message.PLAYERREQUIERED.getText(Language.EN));
			return true;
		}
		
		Player p = (Player) sender;
		
		if(BaseBuilder.hasBuilder(p)) {
			removePlayer(p);
		} else {
			addPlayer(p);
		}
		
		return true;
	}

	private void removePlayer(Player player) {
		Location loc = BaseBuilder.getLocation(player);
		player.teleport(loc);
		BaseBuilder.removeBuilder(player);
		
		/*
		 * Reset fly speed due to increase and decrease during building
		 */
		player.setFlySpeed((float) 0.1);
	}
	
	private void addPlayer(Player player) {
		Location loc = player.getLocation();
		
		BaseBuilder.addBuilder(player, player.getLocation());
		
		/*
		 * Make the player look down
		 */
		loc.setYaw(0);
		loc.setPitch(90);
		loc.setX(0);
		loc.setZ(0);
		
		loc.setY(30);
		player.teleport(loc);
	}
}

package de.idev.basebuilder.events;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

import de.idev.basebuilder.BaseBuilder;
import de.idev.tools.data.GenericDataStorage;
import de.idev.tools.data.IDataStorage;
import de.idev.tools.schematic.Schematic;
import de.idev.tools.schematic.util.SchematicLoader;

public class ElicitationPlayerInteractEvent implements Listener {

	private static final Schematic defaultSchematic = SchematicLoader.loadSchematic("rec");

	/*
	 * Event to check the interaction of all Players Only works if players is
	 * holding a item when called
	 * 
	 * @param e is the PlayerInteractEvent
	 */

	@EventHandler
	public void a(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_AIR)
			return;
		if (!BaseBuilder.hasBuilder(e.getPlayer()))
			return;
		Player player = e.getPlayer();

		Chunk chunk = getChunk(player);
		if (chunk == null)
			return;

		if (!isBuildOn(chunk)) {
			buildChunk(chunk, defaultSchematic);
		}
	}

	/*
	 * Returns the Chunk the Player is looking towards at the Time the function is
	 * called maximum range is set to 500
	 * 
	 * 
	 * @param player the player the chunk will be calculated from
	 * 
	 * Might also return Null if no chunk was found
	 */

	private Chunk getChunk(Player player) {
		return player.rayTraceBlocks(500).getHitBlock().getChunk();
	}

	/*
	 * Returns the value of the key GodBuilder#buildFlagKey of a chunk
	 * 
	 * @param chunk is the chunk that's being checked
	 */

	private boolean isBuildOn(Chunk chunk) {
		IDataStorage chunkData = new GenericDataStorage(chunk);
		return chunkData.get(BaseBuilder.buildFlagKey, PersistentDataType.BOOLEAN) != null
				&& chunkData.get(BaseBuilder.buildFlagKey, PersistentDataType.BOOLEAN);
	}

	/*
	 * Sets the builds to the Chunk
	 * 
	 * @param chunk is the chunk that of its base will be placed blocks from
	 * 
	 * @param structure is the structure that will be build
	 * 
	 * IMPLEMENTATION OF SCHEMATIC NEEDS TO BE DONE
	 */

	private void buildChunk(Chunk chunk, Schematic schematic) {
		World world = chunk.getWorld();
		schematic.getBlocks().forEach(x -> {
			Block block = world.getBlockAt(x.getX()+chunk.getX()*16, x.getY(), x.getZ()+chunk.getZ()*16);
			block.setType(x.getMaterial());
			block.setBlockData(Bukkit.createBlockData(x.getBlockData()));
		});
		setChunkBuildStatus(chunk, true);
	}

	/*
	 * Sets the chunkBuild status based on the key in GodBuilder#buildFlagKey
	 * 
	 * @param chunk the chunk that is changed
	 * 
	 * @param status is the state to which it will be set
	 */

	private void setChunkBuildStatus(Chunk chunk, boolean status) {
		IDataStorage chunkData = new GenericDataStorage(chunk);
		chunkData.set(BaseBuilder.buildFlagKey, PersistentDataType.BOOLEAN, status);
		setVisualFlag(chunk, Material.RED_STAINED_GLASS);
	}

	/*
	 * Sets Blocks from y -50 to 10 at chunk position x 8 and z 8
	 * 
	 * @param chunk is the chunk that will be build on
	 * 
	 * @param flagMaterial is the material which will be Build
	 */

	private void setVisualFlag(Chunk chunk, Material flagMaterial) {
		for (int y = -50; y < 10; y++) {
			chunk.getBlock(8, 0, 8).setType(flagMaterial);
		}
	}
}

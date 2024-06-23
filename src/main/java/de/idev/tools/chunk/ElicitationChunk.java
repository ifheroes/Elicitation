package de.idev.tools.chunk;

import org.bukkit.Chunk;

import de.idev.tools.data.GenericDataStorage;

public class ElicitationChunk {

	private Chunk chunk;
	private GenericDataStorage chunkStorage;
	
	public ElicitationChunk(Chunk chunk) {
		setChunk(chunk);
	}

	public Chunk getChunk() {
		return chunk;
	}

	public void setChunk(Chunk chunk) {
		this.chunk = chunk;
		setChunkStorage(new GenericDataStorage(chunk));
	}

	public GenericDataStorage getChunkStorage() {
		return chunkStorage;
	}

	private void setChunkStorage(GenericDataStorage chunkStorage) {
		this.chunkStorage = chunkStorage;
	}
	
	public boolean isMarked(ChunkMark mark) {
		return chunkStorage.has(mark.name());
	}
}

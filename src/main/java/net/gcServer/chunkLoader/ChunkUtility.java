package net.gcServer.chunkLoader;

import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.util.math.ChunkPos;

import java.util.Comparator;

public class ChunkUtility
{
    public static final ChunkTicketType<ChunkPos> NOTE_BLOCK = ChunkTicketType.create("note_block", Comparator.comparingLong(ChunkPos::toLong), 300);
}

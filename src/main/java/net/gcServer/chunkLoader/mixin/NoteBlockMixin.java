package net.gcServer.chunkLoader.mixin;

import net.gcServer.chunkLoader.ChunkUtility;
import net.minecraft.block.NoteBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(NoteBlock.class)
public abstract class NoteBlockMixin
{
    @Inject(at = @At("HEAD"), method = "playNote")
    private void loadChunk(World world, BlockPos pos, CallbackInfo info)
    {
        ChunkPos cp = new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4);
        ((ServerWorld) world).getChunkManager().addTicket(ChunkUtility.NOTE_BLOCK, cp, 3, cp);
    }
}

package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_WitherSkeleton extends NPC_Entity {

    public static final int NID = 48;

    public NPC_WitherSkeleton(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 2.1f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

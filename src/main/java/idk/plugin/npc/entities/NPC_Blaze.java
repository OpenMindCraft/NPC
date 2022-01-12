package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Blaze extends NPC_Entity {

    public static final int NID = 43;

    public NPC_Blaze(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.8f;
    }

    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

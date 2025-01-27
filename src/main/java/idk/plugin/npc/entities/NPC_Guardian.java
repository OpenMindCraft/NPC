package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Guardian extends NPC_Entity {

    public static final int NID = 49;

    public NPC_Guardian(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.85f;
    }

    @Override
    public float getWidth() {
        return 0.85f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

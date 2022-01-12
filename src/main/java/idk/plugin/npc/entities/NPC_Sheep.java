package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Sheep extends NPC_Entity {

    public static final int NID = 13;

    public NPC_Sheep(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.3f;
    }

    @Override
    public float getWidth() {
        return 0.9f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

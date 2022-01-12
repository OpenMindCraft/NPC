package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_IronGolem extends NPC_Entity {

    public static final int NID = 20;

    public NPC_IronGolem(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 2.9f;
    }

    @Override
    public float getWidth() {
        return 1.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

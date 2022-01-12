package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Cat extends NPC_Entity {

    public static final int NID = 75;

    public NPC_Cat(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.56f;
    }

    @Override
    public float getWidth() {
        return 0.48f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

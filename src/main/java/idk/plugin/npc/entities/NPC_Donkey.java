package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Donkey extends NPC_Entity {

    public static final int NID = 24;

    public NPC_Donkey(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.6f;
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

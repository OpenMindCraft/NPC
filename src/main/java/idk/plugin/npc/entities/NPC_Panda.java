package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Panda extends NPC_Entity {

    public static final int NID = 113;

    public NPC_Panda(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.5f;
    }

    @Override
    public float getWidth() {
        return 1.7f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

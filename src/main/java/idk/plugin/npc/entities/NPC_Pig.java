package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Pig extends NPC_Entity {

    public static final int NID = 12;

    public NPC_Pig(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.6f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

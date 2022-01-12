package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Dolphin extends NPC_Entity {

    public static final int NID = 31;

    public NPC_Dolphin(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.39f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

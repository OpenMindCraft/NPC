package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Parrot extends NPC_Entity {

    public static final int NID = 30;

    public NPC_Parrot(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getWidth() {
        return 0.5f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

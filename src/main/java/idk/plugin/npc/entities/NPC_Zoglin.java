package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Zoglin extends NPC_Entity {

    public static final int NID = 126;

    public NPC_Zoglin(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.9f;
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

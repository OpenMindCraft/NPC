package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Balloon extends NPC_Entity {

    public static final int NID = 107;

    public NPC_Balloon(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.5f; // This is a quess
    }

    @Override
    public float getWidth() {
        return 0.5f; // This is a quess
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}
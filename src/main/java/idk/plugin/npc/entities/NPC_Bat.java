package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Bat extends NPC_Entity {

    public static final int NID = 19;

    public NPC_Bat(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}
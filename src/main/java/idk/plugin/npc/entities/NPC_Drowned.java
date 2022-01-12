package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Drowned extends NPC_Entity {

    public static final int NID = 110;

    public NPC_Drowned(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.9f;
    }

    @Override
    public float getWidth() {
        return 1.6f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

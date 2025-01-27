package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Strider extends NPC_Entity {

    public static final int NID = 125;

    public NPC_Strider(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.7f;
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

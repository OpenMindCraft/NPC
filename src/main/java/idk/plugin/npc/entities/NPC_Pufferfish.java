package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Pufferfish extends NPC_Entity {

    public static final int NID = 108;

    public NPC_Pufferfish(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.96f;
    }

    @Override
    public float getWidth() {
        return 0.96f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Chicken extends NPC_Entity {

    public static final int NID = 10;

    public NPC_Chicken(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.8f;
    }

    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

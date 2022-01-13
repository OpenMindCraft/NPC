package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_TopicalFish extends NPC_Entity {

    public static final int NID = 111;

    public NPC_TopicalFish(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.52f;
    }

    @Override
    public float getWidth() {
        return 0.52f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}
package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_CaveSpider extends NPC_Entity {

    public static final int NID = 40;

    public NPC_CaveSpider(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.5f;
    }

    @Override
    public float getWidth() {
        return 0.7f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

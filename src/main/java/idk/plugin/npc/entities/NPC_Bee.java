package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Bee extends NPC_Entity {

    public static final int NID = 122;

    public NPC_Bee(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.5f;
    }

    @Override
    public float getWidth() {
        return 0.55f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}
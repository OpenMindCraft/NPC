package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Turtle extends NPC_Entity {

    public static final int NID = 74;

    public NPC_Turtle(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.4f;
    }

    @Override
    public float getWidth() {
        return 1.2f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Snowman extends NPC_Entity {

    public static final int NID = 21;

    public NPC_Snowman(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.8f;
    }

    @Override
    public float getWidth() {
        return 0.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

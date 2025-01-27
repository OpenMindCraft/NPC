package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Rabbit extends NPC_Entity {

    public static final int NID = 18;

    public NPC_Rabbit(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.402f;
    }

    @Override
    public float getWidth() {
        return 0.402f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Vex extends NPC_Entity {

    public static final int NID = 105;

    public NPC_Vex(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public float getHeight() {
        return 0.8f;
    }

    public float getWidth() {
        return 0.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

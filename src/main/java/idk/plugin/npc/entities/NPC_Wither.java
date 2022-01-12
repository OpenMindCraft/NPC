package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Wither extends NPC_Entity {

    public static final int NID = 52;

    public NPC_Wither(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 3.0f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

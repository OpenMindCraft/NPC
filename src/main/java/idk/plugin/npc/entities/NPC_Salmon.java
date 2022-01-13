package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Salmon extends NPC_Entity {

    public static final int NID = 109;

    public NPC_Salmon(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.5f;
    }

    @Override
    public float getWidth() {
        return 0.5f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

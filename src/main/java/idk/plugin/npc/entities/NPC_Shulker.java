package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Shulker extends NPC_Entity {

    public static final int NID = 54;

    public NPC_Shulker(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.0f;
    }

    @Override
    public float getWidth() {
        return 1.0f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

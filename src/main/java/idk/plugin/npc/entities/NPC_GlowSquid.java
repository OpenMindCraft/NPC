package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_GlowSquid extends NPC_Entity {

    public static final int NID = 129;

    public NPC_GlowSquid(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.95f;
    }

    @Override
    public float getWidth() {
        return 0.95f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

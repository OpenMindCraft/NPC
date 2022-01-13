package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_EnderDragon extends NPC_Entity {

    public static final int NID = 53;

    public NPC_EnderDragon(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 8.0f;
    }

    @Override
    public float getWidth() {
        return 16.0f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

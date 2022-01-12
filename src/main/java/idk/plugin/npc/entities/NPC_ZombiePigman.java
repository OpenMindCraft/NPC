package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_ZombiePigman extends NPC_Entity {

    public static final int NID = 36;

    public NPC_ZombiePigman(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

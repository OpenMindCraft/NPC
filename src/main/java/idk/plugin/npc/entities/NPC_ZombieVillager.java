package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_ZombieVillager extends NPC_Entity {

    public static final int NID = 44;

    public NPC_ZombieVillager(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.9f;
    }

    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

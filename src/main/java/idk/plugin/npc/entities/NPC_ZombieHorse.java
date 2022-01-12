package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_ZombieHorse extends NPC_Entity {

    public static final int NID = 27;

    public NPC_ZombieHorse(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.6f;
    }

    @Override
    public float getWidth() {
        return 1.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

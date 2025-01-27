package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Lama extends NPC_Entity {

    public static final int NID = 29;

    public NPC_Lama(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.87f;
    }

    @Override
    public float getWidth() {
        return 0.9f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

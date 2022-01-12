package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Evoker extends NPC_Entity {

    public static final int NID = 104;

    public NPC_Evoker(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 1.6f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }

}

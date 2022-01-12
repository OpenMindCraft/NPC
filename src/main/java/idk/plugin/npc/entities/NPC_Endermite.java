package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Endermite extends NPC_Entity {

    public static final int NID = 55;

    public NPC_Endermite(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.3f;
    }

    @Override
    public float getWidth() {
        return 0.4f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

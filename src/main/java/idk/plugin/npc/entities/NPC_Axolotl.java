package idk.plugin.npc.entities;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class NPC_Axolotl extends NPC_Entity {

    public static final int NID = 130;

    public NPC_Axolotl(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getHeight() {
        return 0.375f;
    }

    @Override
    public float getWidth() {
        return 0.75f;
    }

    @Override
    public int getNetworkId() {
        return NID;
    }
}

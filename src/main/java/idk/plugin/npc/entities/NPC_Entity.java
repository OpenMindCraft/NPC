package idk.plugin.npc.entities;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.data.FloatEntityData;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public abstract class NPC_Entity extends Entity {

    public NPC_Entity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setDataProperty(new FloatEntityData(DATA_SCALE, this.namedTag.getFloat("scale")));
    }

    @Override
    public float getHeight() {
        return 1.0f;
    }

    @Override
    public float getWidth() {
        return 1.0f;
    }
}

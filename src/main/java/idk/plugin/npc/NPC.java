package idk.plugin.npc;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.nbt.tag.*;
import cn.nukkit.plugin.PluginBase;
import idk.plugin.npc.entities.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NPC extends PluginBase {

        static List<String> id = new ArrayList<>();
        static List<String> kill = new ArrayList<>();

        @Override
        public void onEnable() {
                this.registerNPC();
                this.getServer().getCommandMap().register("npc", new NPCCommand(this));
                this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        }

        private void registerNPC() {
                Entity.registerEntity(NPC_Agent.class.getSimpleName(), NPC_Agent.class);
                Entity.registerEntity(NPC_Axolotl.class.getSimpleName(), NPC_Axolotl.class);
                Entity.registerEntity(NPC_Bat.class.getSimpleName(), NPC_Bat.class);
                Entity.registerEntity(NPC_Bee.class.getSimpleName(), NPC_Bee.class);
                Entity.registerEntity(NPC_Blaze.class.getSimpleName(), NPC_Blaze.class);
                Entity.registerEntity(NPC_Cat.class.getSimpleName(), NPC_Cat.class);
                Entity.registerEntity(NPC_CaveSpider.class.getSimpleName(), NPC_CaveSpider.class);
                Entity.registerEntity(NPC_Chicken.class.getSimpleName(), NPC_Chicken.class);
                Entity.registerEntity(NPC_Cod.class.getSimpleName(), NPC_Cod.class);
                Entity.registerEntity(NPC_Cow.class.getSimpleName(), NPC_Cow.class);
                Entity.registerEntity(NPC_Creeper.class.getSimpleName(), NPC_Creeper.class);
                Entity.registerEntity(NPC_Dolphin.class.getSimpleName(), NPC_Dolphin.class);
                Entity.registerEntity(NPC_Donkey.class.getSimpleName(), NPC_Donkey.class);
                Entity.registerEntity(NPC_Drowned.class.getSimpleName(), NPC_Drowned.class);
                Entity.registerEntity(NPC_ElderGuardian.class.getSimpleName(), NPC_ElderGuardian.class);
                // Entity.registerEntity(NPC_EnderDragon.class.getSimpleName(),
                // NPC_EnderDragon.class);
                Entity.registerEntity(NPC_Enderman.class.getSimpleName(), NPC_Enderman.class);
                Entity.registerEntity(NPC_Endermite.class.getSimpleName(), NPC_Endermite.class);
                Entity.registerEntity(NPC_Entity.class.getSimpleName(), NPC_Entity.class);
                Entity.registerEntity(NPC_Evoker.class.getSimpleName(), NPC_Evoker.class);
                Entity.registerEntity(NPC_Fox.class.getSimpleName(), NPC_Fox.class);
                Entity.registerEntity(NPC_Ghast.class.getSimpleName(), NPC_Ghast.class);
                Entity.registerEntity(NPC_GlowSquid.class.getSimpleName(), NPC_GlowSquid.class);
                Entity.registerEntity(NPC_Goat.class.getSimpleName(), NPC_Goat.class);
                Entity.registerEntity(NPC_Guardian.class.getSimpleName(), NPC_Guardian.class);
                Entity.registerEntity(NPC_Hoglin.class.getSimpleName(), NPC_Hoglin.class);
                Entity.registerEntity(NPC_Horse.class.getSimpleName(), NPC_Horse.class);
                Entity.registerEntity(NPC_Human.class.getSimpleName(), NPC_Human.class);
                Entity.registerEntity(NPC_Husk.class.getSimpleName(), NPC_Husk.class);
                Entity.registerEntity(NPC_IronGolem.class.getSimpleName(), NPC_IronGolem.class);
                Entity.registerEntity(NPC_Lama.class.getSimpleName(), NPC_Lama.class);
                Entity.registerEntity(NPC_MagmaCube.class.getSimpleName(), NPC_MagmaCube.class);
                Entity.registerEntity(NPC_Mooshroom.class.getSimpleName(), NPC_Mooshroom.class);
                Entity.registerEntity(NPC_Mule.class.getSimpleName(), NPC_Mule.class);
                // Entity.registerEntity(NPC_Npc.class.getSimpleName(), NPC_Npc.class);
                Entity.registerEntity(NPC_Ocelot.class.getSimpleName(), NPC_Ocelot.class);
                Entity.registerEntity(NPC_Panda.class.getSimpleName(), NPC_Panda.class);
                Entity.registerEntity(NPC_Parrot.class.getSimpleName(), NPC_Parrot.class);
                Entity.registerEntity(NPC_Phantom.class.getSimpleName(), NPC_Phantom.class);
                Entity.registerEntity(NPC_Pig.class.getSimpleName(), NPC_Pig.class);
                Entity.registerEntity(NPC_Piglin.class.getSimpleName(), NPC_Piglin.class);
                Entity.registerEntity(NPC_PiglinBrute.class.getSimpleName(), NPC_PiglinBrute.class);
                Entity.registerEntity(NPC_Pillager.class.getSimpleName(), NPC_Pillager.class);
                Entity.registerEntity(NPC_PolarBear.class.getSimpleName(), NPC_PolarBear.class);
                Entity.registerEntity(NPC_Pufferfish.class.getSimpleName(), NPC_Pufferfish.class);
                Entity.registerEntity(NPC_Rabbit.class.getSimpleName(), NPC_Rabbit.class);
                Entity.registerEntity(NPC_Ravager.class.getSimpleName(), NPC_Ravager.class);
                Entity.registerEntity(NPC_Salmon.class.getSimpleName(), NPC_Salmon.class);
                Entity.registerEntity(NPC_Sheep.class.getSimpleName(), NPC_Sheep.class);
                Entity.registerEntity(NPC_Shulker.class.getSimpleName(), NPC_Shulker.class);
                Entity.registerEntity(NPC_Silverfish.class.getSimpleName(), NPC_Silverfish.class);
                Entity.registerEntity(NPC_Skeleton.class.getSimpleName(), NPC_Skeleton.class);
                Entity.registerEntity(NPC_SkeletonHorse.class.getSimpleName(), NPC_SkeletonHorse.class);
                Entity.registerEntity(NPC_Slime.class.getSimpleName(), NPC_Slime.class);
                Entity.registerEntity(NPC_Snowman.class.getSimpleName(), NPC_Snowman.class);
                Entity.registerEntity(NPC_Spider.class.getSimpleName(), NPC_Spider.class);
                Entity.registerEntity(NPC_Squid.class.getSimpleName(), NPC_Squid.class);
                Entity.registerEntity(NPC_Stray.class.getSimpleName(), NPC_Stray.class);
                Entity.registerEntity(NPC_Strider.class.getSimpleName(), NPC_Strider.class);
                Entity.registerEntity(NPC_TopicalFish.class.getSimpleName(), NPC_TopicalFish.class);
                Entity.registerEntity(NPC_TripodCamera.class.getSimpleName(), NPC_TripodCamera.class);
                Entity.registerEntity(NPC_Turtle.class.getSimpleName(), NPC_Turtle.class);
                Entity.registerEntity(NPC_Vex.class.getSimpleName(), NPC_Vex.class);
                Entity.registerEntity(NPC_Villager.class.getSimpleName(), NPC_Villager.class);
                Entity.registerEntity(NPC_VillagerV2.class.getSimpleName(), NPC_VillagerV2.class);
                Entity.registerEntity(NPC_Vindicator.class.getSimpleName(), NPC_Vindicator.class);
                Entity.registerEntity(NPC_WanderingTrader.class.getSimpleName(), NPC_WanderingTrader.class);
                Entity.registerEntity(NPC_Witch.class.getSimpleName(), NPC_Witch.class);
                Entity.registerEntity(NPC_Wither.class.getSimpleName(), NPC_Wither.class);
                Entity.registerEntity(NPC_WitherSkeleton.class.getSimpleName(), NPC_WitherSkeleton.class);
                Entity.registerEntity(NPC_Wolf.class.getSimpleName(), NPC_Wolf.class);
                Entity.registerEntity(NPC_Zoglin.class.getSimpleName(), NPC_Zoglin.class);
                Entity.registerEntity(NPC_Zombie.class.getSimpleName(), NPC_Zombie.class);
                Entity.registerEntity(NPC_ZombieHorse.class.getSimpleName(), NPC_ZombieHorse.class);
                Entity.registerEntity(NPC_ZombiePigman.class.getSimpleName(), NPC_ZombiePigman.class);
                Entity.registerEntity(NPC_ZombieVillager.class.getSimpleName(), NPC_ZombieVillager.class);
                Entity.registerEntity(NPC_ZombieVillagerV2.class.getSimpleName(), NPC_ZombieVillagerV2.class);
        }

        public static CompoundTag nbt(Player p, String[] args, String name) {
                CompoundTag nbt = new CompoundTag()
                                .putList(new ListTag<>("Pos")
                                                .add(new DoubleTag("", p.x))
                                                .add(new DoubleTag("", p.y))
                                                .add(new DoubleTag("", p.z)))
                                .putList(new ListTag<DoubleTag>("Motion")
                                                .add(new DoubleTag("", 0))
                                                .add(new DoubleTag("", 0))
                                                .add(new DoubleTag("", 0)))
                                .putList(new ListTag<FloatTag>("Rotation")
                                                .add(new FloatTag("", (float) p.getYaw()))
                                                .add(new FloatTag("", (float) p.getPitch())))
                                .putBoolean("Invulnerable", true)
                                .putString("NameTag", name)
                                .putList(new ListTag<StringTag>("Commands"))
                                .putList(new ListTag<StringTag>("PlayerCommands"))
                                .putBoolean("npc", true)
                                .putFloat("scale", 1);
                if ("Human".equals(args[1])) {
                        CompoundTag skinTag = new CompoundTag()
                                        .putByteArray("Data", p.getSkin().getSkinData().data)
                                        .putInt("SkinImageWidth", p.getSkin().getSkinData().width)
                                        .putInt("SkinImageHeight", p.getSkin().getSkinData().height)
                                        .putString("ModelId", p.getSkin().getSkinId())
                                        .putString("CapeId", p.getSkin().getCapeId())
                                        .putByteArray("CapeData", p.getSkin().getCapeData().data)
                                        .putInt("CapeImageWidth", p.getSkin().getCapeData().width)
                                        .putInt("CapeImageHeight", p.getSkin().getCapeData().height)
                                        .putByteArray("SkinResourcePatch",
                                                        p.getSkin().getSkinResourcePatch()
                                                                        .getBytes(StandardCharsets.UTF_8))
                                        .putByteArray("GeometryData",
                                                        p.getSkin().getGeometryData().getBytes(StandardCharsets.UTF_8))
                                        .putByteArray("AnimationData",
                                                        p.getSkin().getAnimationData().getBytes(StandardCharsets.UTF_8))
                                        .putBoolean("PremiumSkin", p.getSkin().isPremium())
                                        .putBoolean("PersonaSkin", p.getSkin().isPersona())
                                        .putBoolean("CapeOnClassicSkin", p.getSkin().isCapeOnClassic());
                        nbt.putCompound("Skin", skinTag);
                        nbt.putBoolean("ishuman", true);
                        nbt.putString("Item", p.getInventory().getItemInHand().getName());
                        nbt.putString("Helmet", p.getInventory().getHelmet().getName());
                        nbt.putString("Chestplate", p.getInventory().getChestplate().getName());
                        nbt.putString("Leggings", p.getInventory().getLeggings().getName());
                        nbt.putString("Boots", p.getInventory().getBoots().getName());
                }
                return nbt;
        }
}

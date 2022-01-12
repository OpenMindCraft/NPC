package idk.plugin.npc;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.nbt.tag.*;
import cn.nukkit.plugin.PluginBase;
import idk.plugin.npc.entities.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NPC extends PluginBase {

    public static final List<String> entities = Arrays.asList("Bat", "Blaze", "Cat", "CaveSpider", "Chicken", "Cow",
            "Creeper", "Dolphin", "Donkey", "ElderGuardian", "Enderman", "Endermite", "Evoker", "Ghast", "Guardian",
            "Horse", "Human", "Husk", "IronGolem", "Lama", "Mooshroom", "MagmaCube", "Mule", "Ocelot", "Panda",
            "Parrot", "Phantom", "Pig", "Pillager", "PolarBear", "Rabbit", "SkeletonHorse", "Sheep", "Shulker",
            "Silverfish", "Skeleton", "Slime", "Snowman", "Spider", "Squid", "Stray", "Turtle", "Vex", "Villager",
            "Vindicator", "WanderingTrader", "Witch", "Wither", "WitherSkeleton", "Wolf", "ZombieHorse", "Zombie",
            "ZombiePigman", "ZombieVillager");

    static List<String> id = new ArrayList<>();
    static List<String> kill = new ArrayList<>();

    @Override
    public void onEnable() {
        registerNPC();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    private void registerNPC() {
        Entity.registerEntity(NPC_Bat.class.getSimpleName(), NPC_Bat.class);
        Entity.registerEntity(NPC_Chicken.class.getSimpleName(), NPC_Chicken.class);
        Entity.registerEntity(NPC_Cow.class.getSimpleName(), NPC_Cow.class);
        Entity.registerEntity(NPC_Donkey.class.getSimpleName(), NPC_Donkey.class);
        Entity.registerEntity(NPC_Horse.class.getSimpleName(), NPC_Horse.class);
        Entity.registerEntity(NPC_Mooshroom.class.getSimpleName(), NPC_Mooshroom.class);
        Entity.registerEntity(NPC_Mule.class.getSimpleName(), NPC_Mule.class);
        Entity.registerEntity(NPC_Ocelot.class.getSimpleName(), NPC_Ocelot.class);
        Entity.registerEntity(NPC_Pig.class.getSimpleName(), NPC_Pig.class);
        Entity.registerEntity(NPC_PolarBear.class.getSimpleName(), NPC_PolarBear.class);
        Entity.registerEntity(NPC_Rabbit.class.getSimpleName(), NPC_Rabbit.class);
        Entity.registerEntity(NPC_Sheep.class.getSimpleName(), NPC_Sheep.class);
        Entity.registerEntity(NPC_SkeletonHorse.class.getSimpleName(), NPC_SkeletonHorse.class);
        Entity.registerEntity(NPC_Villager.class.getSimpleName(), NPC_Villager.class);
        Entity.registerEntity(NPC_Wolf.class.getSimpleName(), NPC_Wolf.class);
        Entity.registerEntity(NPC_ZombieHorse.class.getSimpleName(), NPC_ZombieHorse.class);
        Entity.registerEntity(NPC_ElderGuardian.class.getSimpleName(), NPC_ElderGuardian.class);
        Entity.registerEntity(NPC_Guardian.class.getSimpleName(), NPC_Guardian.class);
        Entity.registerEntity(NPC_Snowman.class.getSimpleName(), NPC_Snowman.class);
        Entity.registerEntity(NPC_Lama.class.getSimpleName(), NPC_Lama.class);
        Entity.registerEntity(NPC_Squid.class.getSimpleName(), NPC_Squid.class);
        Entity.registerEntity(NPC_Vindicator.class.getSimpleName(), NPC_Vindicator.class);
        Entity.registerEntity(NPC_Vex.class.getSimpleName(), NPC_Vex.class);
        Entity.registerEntity(NPC_IronGolem.class.getSimpleName(), NPC_IronGolem.class);
        Entity.registerEntity(NPC_Blaze.class.getSimpleName(), NPC_Blaze.class);
        Entity.registerEntity(NPC_Wither.class.getSimpleName(), NPC_Wither.class);
        Entity.registerEntity(NPC_Ghast.class.getSimpleName(), NPC_Ghast.class);
        Entity.registerEntity(NPC_CaveSpider.class.getSimpleName(), NPC_CaveSpider.class);
        Entity.registerEntity(NPC_Creeper.class.getSimpleName(), NPC_Creeper.class);
        Entity.registerEntity(NPC_Enderman.class.getSimpleName(), NPC_Enderman.class);
        Entity.registerEntity(NPC_Endermite.class.getSimpleName(), NPC_Endermite.class);
        Entity.registerEntity(NPC_ZombiePigman.class.getSimpleName(), NPC_ZombiePigman.class);
        Entity.registerEntity(NPC_Silverfish.class.getSimpleName(), NPC_Silverfish.class);
        Entity.registerEntity(NPC_Skeleton.class.getSimpleName(), NPC_Skeleton.class);
        Entity.registerEntity(NPC_Spider.class.getSimpleName(), NPC_Spider.class);
        Entity.registerEntity(NPC_Stray.class.getSimpleName(), NPC_Stray.class);
        Entity.registerEntity(NPC_Witch.class.getSimpleName(), NPC_Witch.class);
        Entity.registerEntity(NPC_Husk.class.getSimpleName(), NPC_Husk.class);
        Entity.registerEntity(NPC_Zombie.class.getSimpleName(), NPC_Zombie.class);
        Entity.registerEntity(NPC_ZombieVillager.class.getSimpleName(), NPC_ZombieVillager.class);
        Entity.registerEntity(NPC_Evoker.class.getSimpleName(), NPC_Evoker.class);
        Entity.registerEntity(NPC_Shulker.class.getSimpleName(), NPC_Shulker.class);
        Entity.registerEntity(NPC_Slime.class.getSimpleName(), NPC_Slime.class);
        Entity.registerEntity(NPC_WitherSkeleton.class.getSimpleName(), NPC_WitherSkeleton.class);
        Entity.registerEntity(NPC_MagmaCube.class.getSimpleName(), NPC_MagmaCube.class);
        Entity.registerEntity(NPC_Human.class.getSimpleName(), NPC_Human.class);
        Entity.registerEntity(NPC_Parrot.class.getSimpleName(), NPC_Parrot.class);
        Entity.registerEntity(NPC_Dolphin.class.getSimpleName(), NPC_Dolphin.class);
        Entity.registerEntity(NPC_Turtle.class.getSimpleName(), NPC_Turtle.class);
        Entity.registerEntity(NPC_Phantom.class.getSimpleName(), NPC_Phantom.class);
        Entity.registerEntity(NPC_Drowned.class.getSimpleName(), NPC_Drowned.class);
        Entity.registerEntity(NPC_Cat.class.getSimpleName(), NPC_Cat.class);
        Entity.registerEntity(NPC_Panda.class.getSimpleName(), NPC_Panda.class);
        Entity.registerEntity(NPC_Pillager.class.getSimpleName(), NPC_Pillager.class);
        Entity.registerEntity(NPC_WanderingTrader.class.getSimpleName(), NPC_WanderingTrader.class);
    }

    public CompoundTag nbt(Player p, String[] args, String name) {
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
                            p.getSkin().getSkinResourcePatch().getBytes(StandardCharsets.UTF_8))
                    .putByteArray("GeometryData", p.getSkin().getGeometryData().getBytes(StandardCharsets.UTF_8))
                    .putByteArray("AnimationData", p.getSkin().getAnimationData().getBytes(StandardCharsets.UTF_8))
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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cThis command only works in game");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("npc")) {
            if (args.length < 1) {
                sendHelp(sender);
                return true;
            }
            switch (args[0].toLowerCase()) {
                case "spawn":
                    if (args.length < 2) {
                        sender.sendMessage("§cUsage: /npc spawn <entity> [name]");
                        return true;
                    }

                    if (!entities.contains(args[1])) {
                        sender.sendMessage("§cEntity §4" + args[1]
                                + "§c is not supported. You can see all supported entities with §e/npc list§c command. Notice that the entity name is case sensitive.");
                        return true;
                    }
                    String name;
                    if (args.length < 2) {
                        name = "%k";
                    } else {
                        name = String.join(" ", args);
                        name = name.replaceFirst("spawn", "");
                        name = name.replaceFirst(args[1], "");
                        name = name.replaceFirst(" ", "");
                        name = name.replaceFirst(" ", "");
                    }
                    name = name.replaceAll("%n", "\n");
                    CompoundTag nbt = this.nbt(player, args, name);
                    Entity ent = Entity.createEntity("NPC_" + args[1], player.chunk, nbt);
                    ent.setNameTag(name);
                    if (!"%k".equals(name)) {
                        ent.setNameTagVisible(true);
                        ent.setNameTagAlwaysVisible(true);
                    }
                    ent.spawnToAll();
                    sender.sendMessage("§aNPC spawned with ID §e" + ent.getId() + " §aand the name §e" + ent.getName());
                    return true;
                case "getid":
                case "id":
                    id.add(player.getName());
                    player.sendMessage("§aID MODE - click an entity to get the ID");
                    return true;
                case "addcmd":
                    if (args.length < 3) {
                        sender.sendMessage("§cUsage: /npc addcmd <ID> <cmd>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        player.sendMessage("§cUsage: /npc addcmd <ID> <cmd>");
                        return true;
                    }
                    Entity enti = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (enti instanceof NPC_Human || enti instanceof NPC_Entity || enti.namedTag.getBoolean("npc")) {
                        String cmd;
                        cmd = String.join(" ", args);
                        cmd = cmd.replaceFirst("addcmd", "");
                        cmd = cmd.replaceFirst(args[1], "");
                        StringTag st = new StringTag(cmd, cmd);
                        if (enti.namedTag.getList("Commands", StringTag.class).getAll().contains(st)) {
                            player.sendMessage("§aCommand already added");
                            return true;
                        }
                        enti.namedTag.getList("Commands", StringTag.class).add(st);
                        player.sendMessage("§aCommand added");
                        return true;
                    } else {
                        player.sendMessage("§cNo NPC found with that ID");
                        return true;
                    }
                case "addplayercmd":
                    if (args.length < 3) {
                        sender.sendMessage("§cUsage: /npc addplayercmd <ID> <cmd>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        player.sendMessage("§cUsage: /npc addplayercmd <ID> <cmd>");
                        return true;
                    }
                    Entity enti2 = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (enti2 instanceof NPC_Human || enti2 instanceof NPC_Entity || enti2.namedTag.getBoolean("npc")) {
                        String cmd;
                        cmd = String.join(" ", args);
                        cmd = cmd.replaceFirst("addplayercmd", "");
                        cmd = cmd.replaceFirst(args[1], "");
                        StringTag st = new StringTag(cmd, cmd);
                        if (enti2.namedTag.getList("PlayerCommands", StringTag.class).getAll().contains(st)) {
                            player.sendMessage("§aCommand already added");
                            return true;
                        }
                        enti2.namedTag.getList("PlayerCommands", StringTag.class).add(st);
                        player.sendMessage("§aCommand added");
                        return true;
                    } else {
                        player.sendMessage("§cNo NPC found with that ID");
                        return true;
                    }
                case "listcmd":
                    if (args.length < 2) {
                        sender.sendMessage("§cUsage: /npc listcmd <ID>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        sender.sendMessage("§cUsage: /npc listcmdd <ID>");
                        return true;
                    }
                    Entity entity = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (entity instanceof NPC_Entity || entity instanceof NPC_Human
                            || entity.namedTag.getBoolean("npc")) {
                        List<StringTag> cmddd = entity.namedTag.getList("Commands", StringTag.class).getAll();
                        player.sendMessage("§aCommands of §e" + entity.getName() + " (" + entity.getId() + ")§a:");
                        for (StringTag cmdd : cmddd) {
                            player.sendMessage(cmdd.data);
                        }
                        List<StringTag> cmdddd = entity.namedTag.getList("PlayerCommands", StringTag.class).getAll();
                        player.sendMessage(
                                "§aPlayer commands of §e" + entity.getName() + " (" + entity.getId() + ")§a:");
                        for (StringTag cmdd : cmdddd) {
                            player.sendMessage(cmdd.data);
                        }
                        return true;
                    } else {
                        player.sendMessage("§cNo NPC found with that ID");
                        return true;
                    }
                case "delcmd":
                    if (args.length < 3) {
                        sender.sendMessage("§cUsage: /npc delcmd <ID> <cmd>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        player.sendMessage("§cUsage: /npc delcmd <ID> <cmd>");
                        return true;
                    }
                    Entity en = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (en instanceof NPC_Human || en instanceof NPC_Entity || en.namedTag.getBoolean("npc")) {
                        String cmd;
                        cmd = String.join(" ", args);
                        cmd = cmd.replaceFirst("delcmd", "");
                        cmd = cmd.replaceFirst(args[1], "");
                        StringTag st = new StringTag(cmd, cmd);
                        if (en.namedTag.getList("Commands", StringTag.class).getAll().contains(st)) {
                            en.namedTag.getList("Commands", StringTag.class).remove(st);
                            player.sendMessage("§aCommand §e" + cmd + "§a removed");
                            return true;
                        } else {
                            player.sendMessage("§cCommand §e" + cmd + "§c not found");
                            return true;
                        }
                    } else {
                        player.sendMessage("§cNo NPC found with that ID");
                        return true;
                    }
                case "delplayercmd":
                    if (args.length < 3) {
                        sender.sendMessage("§cUsage: /npc delplayercmd <ID> <cmd>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        player.sendMessage("§cUsage: /npc delplayercmd <ID> <cmd>");
                        return true;
                    }
                    Entity en2 = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (en2 instanceof NPC_Human || en2 instanceof NPC_Entity || en2.namedTag.getBoolean("npc")) {
                        String cmd;
                        cmd = String.join(" ", args);
                        cmd = cmd.replaceFirst("delplayercmd", "");
                        cmd = cmd.replaceFirst(args[1], "");
                        StringTag st = new StringTag(cmd, cmd);
                        if (en2.namedTag.getList("PlayerCommands", StringTag.class).getAll().contains(st)) {
                            en2.namedTag.getList("PlayerCommands", StringTag.class).remove(st);
                            player.sendMessage("§aCommand §e" + cmd + "§a removed");
                            return true;
                        } else {
                            player.sendMessage("§cCommand §e" + cmd + "§c not found");
                            return true;
                        }
                    } else {
                        player.sendMessage("§cNo NPC found with that ID");
                        return true;
                    }
                case "delallcmd":
                    if (args.length < 2) {
                        sender.sendMessage("§cUsage: /npc delallcmd <ID>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        player.sendMessage("§cUsage: /npc delallcmd <ID>");
                        return true;
                    }
                    Entity en3 = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (en3 instanceof NPC_Human || en3 instanceof NPC_Entity || en3.namedTag.getBoolean("npc")) {
                        en3.namedTag.putList(new ListTag<StringTag>("Commands"))
                                .putList(new ListTag<StringTag>("PlayerCommands"));
                        sender.sendMessage("§aCommands removed");
                    } else {
                        player.sendMessage("§cNo NPC found with that ID");
                        return true;
                    }
                case "edit":
                    if (args.length < 3) {
                        player.sendMessage("§cUsage: /npc edit <ID> <item|armor|scale|name|tphere>");
                        return true;
                    }
                    if (!isInteger(args[1])) {
                        sender.sendMessage("§cUsage: /npc edit <ID> <item|armor|scale|name|tphere>");
                        return true;
                    }
                    Entity e = player.getLevel().getEntity(Integer.parseInt(args[1]));
                    if (e == null) {
                        player.sendMessage("§cno entity found with that ID");
                        return true;
                    }
                    PlayerInventory pl = player.getInventory();
                    switch (args[2].toLowerCase()) {
                        case "handitem":
                        case "item":
                        case "hand":
                            if (e instanceof NPC_Human || e.namedTag.getBoolean("ishuman")) {
                                NPC_Human nh = (NPC_Human) e;
                                nh.getInventory().setItemInHand(pl.getItemInHand());
                                player.sendMessage("§aItem changed to §e" + pl.getItemInHand().getName());
                                nh.namedTag.putString("Item", pl.getItemInHand().getName());
                                return true;
                            } else {
                                player.sendMessage("§cThat entity can't have item");
                                return true;
                            }
                        case "armor":
                            if (e instanceof NPC_Human || e.namedTag.getBoolean("ishuman")) {
                                NPC_Human nh = (NPC_Human) e;
                                nh.getInventory().setHelmet(pl.getHelmet());
                                player.sendMessage("§aHelmet changed to §e" + pl.getHelmet().getName());
                                nh.namedTag.putString("Helmet", pl.getHelmet().getName());
                                nh.getInventory().setChestplate(pl.getChestplate());
                                player.sendMessage("§aChestplate changed to §e" + pl.getChestplate().getName());
                                nh.namedTag.putString("Chestplate", pl.getChestplate().getName());
                                nh.getInventory().setLeggings(pl.getLeggings());
                                player.sendMessage("§aLeggings changed to §e" + pl.getLeggings().getName());
                                nh.namedTag.putString("Leggings", pl.getLeggings().getName());
                                nh.getInventory().setBoots(pl.getBoots());
                                player.sendMessage("§aBoots changed to §e" + pl.getBoots().getName());
                                nh.namedTag.putString("Boots", pl.getBoots().getName());
                                return true;
                            } else {
                                player.sendMessage("§cNo Human NPC found with that ID");
                                return true;
                            }
                        case "scale":
                        case "size":
                            if (args.length < 4) {
                                player.sendMessage("§cUsage: /npc edit <ID> scale <int> §eDefault is 1.");
                                return true;
                            }
                            if (!isFloat(args[3])) {
                                player.sendMessage("§cUsage: /npc edit <ID> scale <int> §eDefault is 1.");
                                return true;
                            }
                            if (Float.parseFloat(args[3]) > 25) {
                                player.sendMessage("§cMax scale is 25");
                                return true;
                            }
                            if (e instanceof NPC_Human || e instanceof NPC_Entity || e.namedTag.getBoolean("npc")) {
                                e.setScale(Float.parseFloat(args[3]));
                                e.namedTag.putFloat("scale", Float.parseFloat(args[3]));
                                player.sendMessage("§aScale changed to §e" + args[3]);
                                return true;
                            } else {
                                player.sendMessage("§cNo NPC found with that ID");
                                return true;
                            }
                        case "name":
                            if (args.length < 3) {
                                player.sendMessage("§cUsage: /npc edit <ID> name <name>");
                                return true;
                            }
                            if (e instanceof NPC_Human || e instanceof NPC_Entity || e.namedTag.getBoolean("npc")) {
                                if (args.length != 3) {
                                    name = String.join(" ", args);
                                    name = name.replaceFirst("edit", "");
                                    name = name.replaceFirst("name", "");
                                    name = name.replaceFirst(args[1], "");
                                    name = name.replaceFirst(" ", "");
                                    name = name.replaceFirst(" ", "");
                                    name = name.replaceFirst(" ", "");
                                } else {
                                    name = "%k";
                                    e.setNameTagVisible(false);
                                    e.setNameTagAlwaysVisible(false);
                                    player.sendMessage("§aName removed");
                                }
                                name = name.replaceAll("%n", "\n");
                                if (!name.equals("%k")) {
                                    e.setNameTag(name);
                                    e.setNameTagVisible();
                                    player.sendMessage("§aName changed to §e" + name);
                                }
                                e.namedTag.putString("NameTag", name);
                                return true;
                            } else {
                                player.sendMessage("§cNo NPC found with that ID");
                                return true;
                            }
                        case "gohere":
                        case "tphere":
                        case "tp":
                        case "teleport":
                            if (args.length < 2) {
                                player.sendMessage("§cUsage: /npc edit <ID> tphere");
                                return true;
                            }
                            if (e instanceof NPC_Human || e instanceof NPC_Entity || e.namedTag.getBoolean("npc")) {
                                e.teleport(player);
                                e.respawnToAll();
                                player.sendMessage("§aEntity teleported");
                                return true;
                            }
                    }
                case "remove":
                case "kill":
                    if (kill.contains(player.getName())) {
                        kill.remove(player.getName());
                        player.sendMessage("§cKill mode deactivated");
                    } else {
                        kill.add(player.getName());
                        player.sendMessage("§aKILL MODE - click an entity to remove it");
                    }
                    return true;
                case "entities":
                case "list":
                    sender.sendMessage("§aAvailable entities: §3" + entities.toString());
                    return true;
                default:
                    sendHelp(sender);
                    return true;
            }
        }

        return true;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static void sendHelp(CommandSender sender) {
        sender.sendMessage("§l§a--- NPC HELP ---");
        sender.sendMessage("§3Spawn NPC: §e/npc spawn <entity> <name>");
        sender.sendMessage("§3Add console command: §e/npc addcmd <ID> <cmd>");
        sender.sendMessage("§3Add player command: §e/npc addplayercmd <ID> <cmd>");
        sender.sendMessage("§3Delete console command: §e/npc delcmd <ID> <cmd>");
        sender.sendMessage("§3Delete player command: §e/npc delplayercmd <ID> <cmd>");
        sender.sendMessage("§3Delete all commands: §e/npc delallcmd <ID>");
        sender.sendMessage("§3See all commands: §e/npc listcmd <ID>");
        sender.sendMessage("§3Edit NPC: §e/npc edit <ID> <item|armor|scale|name|tphere>");
        sender.sendMessage("§3Get NPCs id: §e/npc getid");
        sender.sendMessage("§3Get list of all available entities: §e/npc entities");
        sender.sendMessage("§3Remove NPC: §e/npc remove");
    }
}

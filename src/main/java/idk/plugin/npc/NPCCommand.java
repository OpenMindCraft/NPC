package idk.plugin.npc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.command.data.CommandEnum;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.entity.Entity;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.nbt.tag.StringTag;
import idk.plugin.npc.entities.NPC_Entity;
import idk.plugin.npc.entities.NPC_Human;

public class NPCCommand extends PluginCommand<NPC> {
    public static final List<String> entities = Arrays.asList("Agent", "Axolotl", "Balloon", "Bat", "Bee", "Blaze",
            "Cat", "CaveSpider", "Chicken", "Cod", "Cow", "Creeper", "Dolphin", "Donkey", "Drowned", "ElderGuardian",
            "EnderDragon", "Enderman", "Endermite", "Entity", "Evoker", "Fox", "Ghast", "GlowSquid", "Goat", "Guardian",
            "Hoglin", "Horse", "Human", "Husk", "IronGolem", "Lama", "MagmaCube", "Mooshroom", "Mule", "Npc", "Ocelot",
            "Panda", "Parrot", "Phantom", "Pig", "Piglin", "PiglinBrute", "Pillager", "PolarBear", "Pufferfish",
            "Rabbit", "Ravager", "Salmon", "Sheep", "Shulker", "Silverfish", "Skeleton", "SkeletonHorse", "Slime",
            "Snowman", "Spider", "Squid", "Stray", "Strider", "TopicalFish", "TripodCamera", "Turtle", "Vex",
            "Villager", "VillagerV2", "Vindicator", "WanderingTrader", "Witch", "Wither", "WitherSkeleton", "Wolf",
            "Zoglin", "Zombie", "ZombieHorse", "ZombiePigman", "ZombieVillager", "ZombieVillagerV2");

    public NPCCommand(NPC owner) {
        super("npc", owner);
        this.commandParameters.clear();
        this.commandParameters.put("npc->spawn", new CommandParameter[] {
                CommandParameter.newEnum("operation", new CommandEnum("spawn")),
                CommandParameter.newEnum("entities",
                        new CommandEnum("entities", NPCCommand.entities.stream()
                                .map(String::toLowerCase)
                                .collect(Collectors.toList()))),
                CommandParameter.newType("name", CommandParamType.TEXT)
        });
        this.commandParameters.put("npc->id->string-param", new CommandParameter[] {
                CommandParameter.newEnum("operation", new CommandEnum("operation", "addcmd",
                        "addplayercmd", "delcmd", "delplayercmd")),
                CommandParameter.newType("id", CommandParamType.INT),
                CommandParameter.newType("input", CommandParamType.TEXT)
        });
        this.commandParameters.put("npc->id-param", new CommandParameter[] {
                CommandParameter.newEnum("operation", new CommandEnum("operation", "delallcmd", "listcmd")),
                CommandParameter.newType("id", CommandParamType.INT),
        });

        this.commandParameters.put("npc->edit", new CommandParameter[] {
                CommandParameter.newType("id", CommandParamType.INT),
                CommandParameter.newEnum("action",
                        new CommandEnum("action", "item", "armor", "scale", "name", "tphere")),
        });
        this.commandParameters.put("npc->operation-param", new CommandParameter[] {
                CommandParameter.newEnum("operation", new CommandEnum("operation", "remove", "getid")),
        });
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cThis command only works in game");
            return true;
        }

        Player player = (Player) sender;

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

                Optional<String> target = entities.stream().filter(args[1]::equalsIgnoreCase).findFirst();
                if (!target.isPresent()) {
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
                    name = name.replaceFirst(target.get(), "");
                    name = name.replaceFirst(" ", "");
                    name = name.replaceFirst(" ", "");
                }
                name = name.replaceAll("%n", "\n");
                args[0] = "";
                CompoundTag nbt = NPC.nbt(player, args, name);
                Entity ent = Entity.createEntity("NPC_" + target.get(), player.chunk, nbt);
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
                NPC.id.add(player.getName());
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
                if (NPC.kill.contains(player.getName())) {
                    NPC.kill.remove(player.getName());
                    player.sendMessage("§cKill mode deactivated");
                } else {
                    NPC.kill.add(player.getName());
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

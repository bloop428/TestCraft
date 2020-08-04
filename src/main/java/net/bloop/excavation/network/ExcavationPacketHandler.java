package net.bloop.excavation.network;

import net.bloop.excavation.Excavation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ExcavationPacketHandler {
    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Excavation.MODID, "excavation"), () -> "1.0", s -> true, s -> true);

        INSTANCE.registerMessage(nextID(),
                PacketExcavate.class,
                PacketExcavate::toBytes,
                PacketExcavate::new,
                PacketExcavate::handle);

        INSTANCE.registerMessage(nextID(),
                PacketAlreadyMining.class,
                PacketAlreadyMining::toBytes,
                PacketAlreadyMining::new,
                PacketAlreadyMining::handle);

        INSTANCE.registerMessage(nextID(),
                PacketKeyIsDown.class,
                PacketKeyIsDown::toBytes,
                PacketKeyIsDown::new,
                PacketKeyIsDown::handle);

        INSTANCE.registerMessage(nextID(),
                PacketKeyIsUp.class,
                PacketKeyIsUp::toBytes,
                PacketKeyIsUp::new,
                PacketKeyIsUp::handle);
    }
}

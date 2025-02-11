package com.example.longnull;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;

@Mod(Longnull.MODID)
public class Longnull {
    public static final String MODID = "longnull";
    private static boolean isServerEnvironment = false;

    public Longnull() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(this::onServerStarting);
    }

    private void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        isServerEnvironment = !server.isSingleplayer();

        if (isServerEnvironment) {
            // サーバー環境ならイベントを登録
            MinecraftForge.EVENT_BUS.register(com.example.longnull.events.ChatToDiscord.class);
        }
    }

    public static boolean isModEnabledForPlayer(String playerName) {
        return isServerEnvironment || playerName.equals("LongExplotion0"); //mcid (adminにしておくといいかも)
        // サーバー環境なら有効 or "LongExplotion0" なら例外的に有効
    }
}

package com.example.longnull.events;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.google.gson.JsonObject;
import com.example.longnull.Longnull;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Mod.EventBusSubscriber
public class ChatToDiscord {
    private static final String WEBHOOK_URL = "ここに入力（必須）"; //※LogToDiscordにもあります

    @SubscribeEvent
    public static void onChatMessage(ServerChatEvent event) {
        String playerName = event.getPlayer().getName().getString();
        String message = event.getMessage().getString();

        // シングルプレイ機能不可
        if (!Longnull.isModEnabledForPlayer(playerName)) {
            return;
        }

        sendToDiscord(playerName, message);
    }

    private static void sendToDiscord(String username, String message) {
        try {
            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            JsonObject json = new JsonObject();
            json.addProperty("username", "Long Server"); // 固定のWebhook名（valueを変更)
            json.addProperty("content", "**" + username + "** : " + message); // メッセージのフォーマット変更

            String jsonString = json.toString();
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            conn.getResponseCode(); // エラーチェック
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

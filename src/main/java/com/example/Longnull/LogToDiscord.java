package com.example.longnull.events;

import net.minecraftforge.event.server.ServerStartingEvent;  // サーバー開始イベント
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.google.gson.JsonObject;
import com.example.longnull.Longnull;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Mod.EventBusSubscriber
public class LogToDiscord {

    private static final String WEBHOOK_URL = "ここに入力（必須）"; //※ChatToDiscordにもあります

    @SubscribeEvent
    public static void onLogMessage(ServerStartingEvent event) {  // サーバー開始時ログ送信
        String logMessage = "ここに入力"; // 固定のログメッセージ（適宜変更してください）



        sendToDiscord(logMessage);
    }

    private static void sendToDiscord(String message) {
        try {
            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            JsonObject json = new JsonObject();
            json.addProperty("username", "Long Server");
            json.addProperty("content", "> **LOG** : " + message); // ログ送信

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

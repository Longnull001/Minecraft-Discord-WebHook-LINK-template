# 使用する際はDiscord利用規約を厳守してください。

### 現在のversionは1.0.1です。

#### 製作に至った理由としてはForge 1.20.1用のWebHook modが存在しておらず、疎かになっていたコーディングも兼ねて作成しました。
#### 自鯖での管理が進んだらぼちぼちアップデートはしていきます。

### これを読んでいる人がいるとしたら、利用していただきありがとうございます。

##### 基本的にはあまり期待しないでください。
##### 期待も何も他の方のソースがちゃんとしているので...

## 環境
- VSCode(Eclipse,IntelliJ etc)
* JDK 17
## 使い方

```
private static final String WEBHOOK_URL = "ここに入力（必須）"; (LogToDiscord)
private static final String WEBHOOK_URL = "ここに入力（必須）"; (ChatToDiscord)
```

LogToDiscord.java と ChatToDiscord.java にこのようなコードが存在しているはずですので
"ここに入力（必須）"
と書かれた場所にWebHookのURLをペーストしてください（※内容は削除してください)

```
@SubscribeEvent
    public static void onLogMessage(ServerStartingEvent event) {  // サーバー開始時ログ送信
        String logMessage = "ここに入力"; // 固定のログメッセージ（適宜変更してください）
```
LogToDiscord.java に存在するこのコードにはサーバー起動時の固定ログを表示させることができます
"ここに入力"
と書かれた場所にメッセージを入力してください. . .

```
JsonObject json = new JsonObject();
            json.addProperty("username", "Long Server");
            json.addProperty("content", "> **LOG** : " + message); // ログ送信
```
LogToDiscord.java に存在するこのコードにはWebHookのBOTの名前の変更をすることができます

```
JsonObject json = new JsonObject();
            json.addProperty("username", "Long Server"); // 固定のWebhook名（valueを変更)
            json.addProperty("content", "**" + username + "** : " + message); // メッセージのフォーマット変更
```
ChatToDiscord.java に存在するこのコードには送信者の名前の変更と、フォーマットの変更を行うことができます。


```
public static boolean isModEnabledForPlayer(String playerName) {
        return isServerEnvironment || playerName.equals("LongExplotion0"); //mcid (adminにしておくといいかも)
        // サーバー環境なら有効 or "LongExplotion0" なら例外的に有効
```
Longnull.java に存在するこのコードにはMODの対象外のmcidを変更することができます
必要に応じて変更してください

(シングルプレイでの検証可能、他サーバーでの使用可能（サーバー側に存在する場合）



最後に```.\gradlew build```を行いjarを作成してください。

# LINK

- [Twitter](https://x.com/Longlong726811)
* [Github](https://github.com/Longnull001)

### DMを送信したい場合は[Twitter](https://x.com/Longlong726811) または ```long019284``` にてDiscordにお問い合わせください

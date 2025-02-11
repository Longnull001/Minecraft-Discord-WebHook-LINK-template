> # :books:  使用する際はDiscord利用規約を厳守してください。

### 現在のversionは1.0.1です。

#### 製作に至った理由としてはForge 1.20.1用のWebHook modが存在しておらず、疎かになっていたコーディングも兼ねて作成しました。
#### 自鯖での管理が進んだらぼちぼちアップデートはしていきます。

### これを読んでいる人がいるとしたら、利用していただきありがとうございます。

##### 基本的にはあまり期待しないでください。
##### 期待も何も他の方のソースがちゃんとしているので... :cry:

## :computer:  環境
- <ins>VSCode (Eclipse,IntelliJ etc)</ins>
* <ins>JDK 17</ins>
## :book:  使い方

```
private static final String WEBHOOK_URL = "ここに入力（必須）"; (LogToDiscord)
private static final String WEBHOOK_URL = "ここに入力（必須）"; (ChatToDiscord)
```

`LogToDiscord.java` と `ChatToDiscord.java`にこのようなコードが存在しているはずですので
`"ここに入力（必須）"`
と書かれた場所に<ins>WebHookのURL</ins>をペーストしてください
> <sub>(※内容は削除してください)</sub>


```
@SubscribeEvent
    public static void onLogMessage(ServerStartingEvent event) {  // サーバー開始時ログ送信
        String logMessage = "ここに入力"; // 固定のログメッセージ（適宜変更してください）
```
`LogToDiscord.java` に存在するこのコードにはサーバー起動時の固定ログを表示させることができます

`"ここに入力"`
と書かれた場所に<ins>メッセージを入力</ins>してください

```
JsonObject json = new JsonObject();
            json.addProperty("username", "Long Server");
            json.addProperty("content", "> **LOG** : " + message); // ログ送信
```
`LogToDiscord.java` に存在するこのコードには<ins>WebHookのBOTの名前の変更</ins>をすることができます

```
JsonObject json = new JsonObject();
            json.addProperty("username", "Long Server"); // 固定のWebhook名（valueを変更)
            json.addProperty("content", "**" + username + "** : " + message); // メッセージのフォーマット変更
```
`ChatToDiscord.java` に存在するこのコードには<ins>送信者の名前の変更</ins>と、<ins>フォーマットの変更</ins>を行うことができます。


```
public static boolean isModEnabledForPlayer(String playerName) {
        return isServerEnvironment || playerName.equals("LongExplotion0"); //mcid (adminにしておくといいかも)
        // サーバー環境なら有効 or "LongExplotion0" なら例外的に有効
```
`Longnull.java` に存在するこのコードには<ins>MODの対象外のmcidを変更</ins>することができます
必要に応じて変更してください
> <sub> (シングルプレイでの検証可能、他サーバーでの使用可能（サーバー側に存在する場合）</sub>


## :bricks:  Building

最後に```.\gradlew build```を行いjarを作成してください。

Jarは```C:\Users\USER\Downloads\forge 1.20.1 mdk server\build\libs```に作成されます。(Default)

## :globe_with_meridians:  LINK

- [Twitter](https://x.com/Longlong726811)
* [Github](https://github.com/Longnull001)

### DMを送信したい場合は [Twitter](https://x.com/Longlong726811) または ```long019284``` にてDiscordにお問い合わせください

## :scroll: License

### > ・MIT License

`Copyright (c) 2025 Longnull001`

`Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:`

`The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.`

`THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.`

### > Oracle JDK License 
[URL](https://www.oracle.com/jp/java/technologies/javase/jdk-faqs.html)

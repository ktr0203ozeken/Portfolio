import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WriteApp implements WriteAppInterface {
    private long messageId=0L; //メッセージIDの初期化
    private final Map<Long,String> messages=new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    @Override
    public long sendMessage(String message) {
        messageId++; //インクリメント
        messages.put(messageId, message); //Mapに格納
        return messageId;  //メッセージidを返す
    }

    @Override
    public String getMessage(long messageId) {
        return messages.getOrDefault(messageId,"このメッセージは存在しません");
    }

    @Override
    public void deleteMessage(long messageId) {

        if (!messages.containsKey(messageId)) {
            System.out.println("メッセージID " + messageId + " は存在しません");
            System.out.println("メッセージIDが正しいか確認してください");
            return; 
        }

        
        System.out.println("メッセージID " + messageId + " を削除しますか？ (y/n)");
        String input = scanner.nextLine().trim().toLowerCase();

        while (!input.equals("y") && !input.equals("n")) {
            System.out.println("無効な入力です。再度入力してください (y/n):");
            input = scanner.nextLine().trim().toLowerCase();
        }
        if (input.equals("y")) {
            messages.remove(messageId);
            System.out.println("メッセージID " + messageId + " を削除しました");
        } else {
            System.out.println("削除をキャンセルしました");
        }
    }


    public static void closeScanner() {
        if (scanner != null) {
        // scannerをインスタンス化している場合は閉じる
        scanner.close();
        System.out.println("Scannerが閉じられました。");
        }
    }
}


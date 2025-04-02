public class MainTest {
    public static void main(String[] args) {

        //WriteAppの動作確認
        WriteApp writeApp =new WriteApp();

        //writeApp.sendMessage
        long messageId=writeApp.sendMessage("こんにちは");
        System.out.println(messageId);

        //writeApp.getMessage
        String message=writeApp.getMessage(1);
        System.out.println(message);
       
        //writeApp.deleteMessage
        writeApp.deleteMessage(1);

        //writeApp.getMessage
        //削除後のメッセージ取得の動作確認
        String message2=writeApp.getMessage(1);
        System.out.println(message2);
    }
}

public interface WriteAppInterface {

    //オーバーライドする必要があるためこのくらいでよい
    //双方向は別のインターフェイスに

    int sendMessage(String message); //メッセージをセットし送る
    String getMessage(int messageId); //メッセージを取得
    void deleteMessage(int messageId); //メッセージを削除
}
-- メッセージテーブルの作成
CREATE TABLE IF NOT EXISTS message (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    -- 送信メッセージ
    content VARCHAR(255) NOT NULL
);
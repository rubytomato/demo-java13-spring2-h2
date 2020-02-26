ALTER TABLE IF EXISTS item DROP CONSTRAINT fk_item__category_id__category__id;
ALTER TABLE IF EXISTS item_stock DROP CONSTRAINT fk_item_stock__item_id__item__id;
ALTER TABLE IF EXISTS user_order DROP CONSTRAINT fk_user_order__user_id__user__id;
ALTER TABLE IF EXISTS user_order_item DROP CONSTRAINT fk_user_order_item__user_order_id__user_order__id;
ALTER TABLE IF EXISTS user_order_item DROP CONSTRAINT fk_user_order_item__item_id__item__id;
ALTER TABLE IF EXISTS user_review DROP CONSTRAINT fk_user_order_review__user_order_id__user_order__id;

DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_stock;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS user_review;

CREATE TABLE IF NOT EXISTS category (
  id                INT AUTO_INCREMENT              COMMENT 'カテゴリID',
  name              VARCHAR(60) NOT NULL            COMMENT 'カテゴリ名',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS item (
  id                INT AUTO_INCREMENT              COMMENT 'アイテムID',
  category_id       INT NOT NULL                    COMMENT 'カテゴリID',
  name              VARCHAR(90) NOT NULL            COMMENT 'アイテム名',
  price             INT NOT NULL                    COMMENT '価格',
  sales_from        DATE NOT NULL                   COMMENT '販売開始日',
  sales_to          DATE NOT NULL                   COMMENT '販売終了日',
  model_type        INT NOT NULL                    COMMENT '型',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS item_stock (
  id                INT AUTO_INCREMENT              COMMENT 'アイテム在庫ID',
  item_id           INT NOT NULL                    COMMENT 'アイテムID',
  stock             INT NOT NULL DEFAULT 0          COMMENT '在庫数',
  available_from    DATE NOT NULL                   COMMENT '利用可能開始日',
  available_to      DATE NULL                       COMMENT '利用可能終了日',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user (
  id                INT AUTO_INCREMENT              COMMENT 'ユーザーID',
  name              VARCHAR(60) NOT NULL            COMMENT 'ネーム',
  gender_type       TINYINT(1) NULL                 COMMENT '性別 0:男性 1:女性',
  prefecture_type   TINYINT(2) NOT NULL DEFAULT 0   COMMENT '都道府県 0:不明 1:北海道-47:沖縄',
  email             VARCHAR(120) NOT NULL           COMMENT 'メールアドレス',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id),
  UNIQUE KEY (email)
);

CREATE TABLE IF NOT EXISTS user_order (
  id                INT AUTO_INCREMENT              COMMENT '注文ID',
  user_id           INT NOT NULL                    COMMENT 'ユーザーID',
  order_at          DATETIME NOT NULL               COMMENT '注文日',
  order_type        TINYINT(1) NOT NULL DEFAULT 0   COMMENT '0:店頭 1:オンライン',
  shipped_at        DATETIME NULL                   COMMENT '配送日',
  cancel_flag       TINYINT(1) NOT NULL DEFAULT 0   COMMENT '1:キャンセル',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_order_item (
  id                INT AUTO_INCREMENT              COMMENT '注文アイテムID',
  user_order_id     INT NOT NULL                    COMMENT '注文ID',
  item_id           INT NOT NULL                    COMMENT 'アイテムID',
  price             INT NOT NULL                    COMMENT '価格',
  amount            TINYINT(1) NOT NULL             COMMENT '注文数',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_order_review (
  id                INT AUTO_INCREMENT              COMMENT 'レビューID',
  user_order_id     INT NOT NULL                    COMMENT '注文ID',
  review_at         DATETIME NOT NULL               COMMENT 'レビュー日',
  review            TEXT NOT NULL                   COMMENT 'レビュー',
  create_at         DATETIME NOT NULL DEFAULT NOW(),
  update_at         DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

ALTER TABLE item ADD CONSTRAINT fk_item__category_id__category__id
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE;

ALTER TABLE item_stock ADD CONSTRAINT fk_item_stock__item_id__item__id
    FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE;

ALTER TABLE user_order ADD CONSTRAINT fk_user_order__user_id__user__id
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE;

ALTER TABLE user_order_item ADD CONSTRAINT fk_user_order_item__user_order_id__user_order__id
    FOREIGN KEY (user_order_id) REFERENCES user_order(id) ON DELETE SET NULL;

ALTER TABLE user_order_item ADD CONSTRAINT fk_user_order_item__item_id__item__id
    FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE SET NULL;

ALTER TABLE user_order_review ADD CONSTRAINT fk_user_order_review__user_order_id__user_order__id
    FOREIGN KEY (user_order_id) REFERENCES user_order(id) ON DELETE SET NULL;

/*
ALTER TABLE user_order_review ADD CONSTRAINT fk_user_order_review__user_id__user__id
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE;
*/
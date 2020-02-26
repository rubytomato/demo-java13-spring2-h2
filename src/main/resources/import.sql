INSERT INTO category (id, name, create_at, update_at) VALUES ( 1, 'Kitchen & Dining', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 2, 'FURNITURE', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 3, 'BEDDING & BATH', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 4, 'Appliances', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 5, 'PATIO,LAWN & GARDEN', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 6, 'ART', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 7, 'PET SUPPLIES', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 8, 'Wedding Registry', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES ( 9, 'Home Improvement', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (10, 'Power and Hand Tools', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (11, 'Lighting & Ceiling Fans', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (12, 'Kitchen & Bath Fixtures', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (13, 'Hardware', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (14, 'SMART HOME', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (15, 'Luxury-Beauty', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (16, 'Mens-Grooming', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (17, 'Health, Household and Baby Care', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (18, 'Vitamins & Dietary Supplements', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (19, 'Food & Beverages', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (20, 'Specialty Diets', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (21, 'Wine', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (22, 'Subscribe & Save', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (23, 'Prime Pantry', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (24, 'Toys & Games', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (25, 'DIGITAL MUSIC', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (26, 'Musical Instruments', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (27, 'HEADPHONES', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (28, 'Video Games', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (29, 'Digital Video Games', now(), now());
INSERT INTO category (id, name, create_at, update_at) VALUES (30, 'Entertainment Collectibles', now(), now());

/* item */
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 1, 1 ,'item_01_1', 100, '2020-01-01', '2020-12-31', 10, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 2, 1, 'item_02_1', 110, '2020-01-01', '2020-12-31', 20, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 3, 1, 'item_03_1', 120, '2020-01-01', '2020-12-31', 30, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 4, 2, 'item_04_2', 130, '2020-01-01', '2020-12-31', 40, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 5, 2, 'item_05_2', 140, '2020-01-01', '2020-12-31', 50, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 6, 3, 'item_06_3', 150, '2020-01-01', '2020-12-31', 60, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 7, 3, 'item_07_3', 160, '2020-01-01', '2020-12-31', 70, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 8, 3, 'item_08_3', 170, '2020-01-01', '2020-12-31', 80, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES ( 9, 3, 'item_09_3', 180, '2020-01-01', '2020-12-31', 90, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (10, 3, 'item_10_3', 190, '2020-01-01', '2020-12-31',100, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (11, 4, 'item_11_4', 200, '2020-01-01', '2020-12-31', 10, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (12, 4, 'item_12_4', 210, '2020-01-01', '2020-12-31', 20, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (13, 4, 'item_13_4', 220, '2020-01-01', '2020-12-31', 30, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (14, 4, 'item_14_4', 230, '2020-01-01', '2020-12-31', 40, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (15, 5, 'item_15_5', 240, '2020-01-01', '2020-12-31', 50, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (16, 5, 'item_16_5', 250, '2020-01-01', '2020-12-31', 60, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (17, 5, 'item_17_5', 260, '2020-01-01', '2020-12-31', 70, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (18, 6, 'item_18_6', 270, '2020-01-01', '2020-12-31', 80, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (19, 6, 'item_19_6', 280, '2020-01-01', '2020-12-31', 90, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (20, 6, 'item_21_6', 290, '2020-01-01', '2020-12-31',100, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (21, 6, 'item_21_6', 300, '2020-01-01', '2020-12-31', 10, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (22, 6, 'item_22_6', 310, '2020-01-01', '2020-12-31', 20, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (23, 7, 'item_23_7', 320, '2020-01-01', '2020-12-31', 30, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (24, 7, 'item_24_7', 330, '2020-01-01', '2020-12-31', 40, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (25, 8, 'item_25_8', 340, '2020-01-01', '2020-12-31', 50, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (26, 8, 'item_26_8', 350, '2020-01-01', '2020-12-31', 60, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (27, 8, 'item_27_8', 360, '2020-01-01', '2020-12-31', 70, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (28, 8, 'item_28_8', 370, '2020-01-01', '2020-12-31', 80, now(), now());

INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (29, 9, 'item_29_9', 380, '2020-01-01', '2020-12-31', 90, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (30, 9, 'item_30_9', 390, '2020-01-01', '2020-12-31',100, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (31, 9, 'item_31_9', 400, '2020-01-01', '2020-12-31', 10, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (32, 9, 'item_32_9', 410, '2020-01-01', '2020-12-31', 20, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (33, 9, 'item_33_9', 420, '2020-01-01', '2020-12-31', 30, now(), now());
INSERT INTO item (id, category_id, name, price, sales_from, sales_to, model_type, create_at, update_at) VALUES (34, 9, 'item_34_9', 430, '2020-01-01', '2020-12-31', 40, now(), now());


/* item_stock */
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 1, 1, 30, '2020-01-01', '2020-01-31', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 2, 1, 35, '2020-02-01', '2020-02-28', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 3, 1, 40, '2020-03-01', '2020-03-31', now(), now());

INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 4, 2, 30, '2020-01-01', '2020-01-31', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 5, 2, 35, '2020-02-01', '2020-02-28', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 6, 2, 40, '2020-03-01', '2020-03-31', now(), now());

INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 7, 3, 40, '2020-02-01', '2020-02-28', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 8, 3, 45, '2020-03-01', '2020-03-31', now(), now());

INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES ( 9, 4, 30, '2020-01-01', '2020-01-31', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES (10, 4, 35, '2020-02-01', '2020-02-28', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES (11, 4, 40, '2020-03-01', '2020-03-31', now(), now());

INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES (12, 5, 30, '2020-01-01', '2020-01-31', now(), now());

INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES (13, 6, 30, '2020-01-01', '2020-01-31', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES (14, 6, 30, '2020-02-01', '2020-02-28', now(), now());
INSERT INTO item_stock (id, item_id, stock, available_from, available_to, create_at, update_at) VALUES (15, 6, 30, '2020-03-01', '2020-03-31', now(), now());

/* user */
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 1, 'user_01', 0, 0, 'user_01@example.com', now(), now());
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 2, 'user_02', 1, 1, 'user_02@example.com', now(), now());
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 3, 'user_03', 0, 2, 'user_03@example.com', now(), now());
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 4, 'user_04', 1, 3, 'user_04@example.com', now(), now());
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 5, 'user_05', 0, 4, 'user_05@example.com', now(), now());
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 6, 'user_06', 1, 5, 'user_06@example.com', now(), now());
INSERT INTO user (id, name, gender_type, prefecture_type, email, create_at, update_at) VALUES ( 7, 'user_07', 0, 6, 'user_07@example.com', now(), now());


/* user_order */
INSERT INTO user_order (id, user_id, order_at, order_type, shipped_at, cancel_flag, create_at, update_at) VALUES (1, 1, '2020-02-04 19:41:00', 0, null, 0, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (1, 1, 1, 100, 3, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (2, 1, 2, 130, 2, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (3, 1, 3, 200, 1, now(), now());

INSERT INTO user_order (id, user_id, order_at, order_type, shipped_at, cancel_flag, create_at, update_at) VALUES (2, 1, '2020-02-04 21:23:00', 0, null, 0, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (4, 2, 1, 100, 1, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (5, 2, 2, 130, 1, now(), now());

INSERT INTO user_order (id, user_id, order_at, order_type, shipped_at, cancel_flag, create_at, update_at) VALUES (3, 2, '2020-02-04 21:24:00', 0, null, 0, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (6, 3, 3, 200, 1, now(), now());

INSERT INTO user_order (id, user_id, order_at, order_type, shipped_at, cancel_flag, create_at, update_at) VALUES (4, 3, '2020-02-01 17:24:00', 0, '2020-02-02 00:00:00', 0, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (7, 4, 1, 100, 1, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (8, 4, 2, 130, 1, now(), now());
INSERT INTO user_order_item (id, user_order_id, item_id, price, amount, create_at, update_at) VALUES (9, 4, 3, 200, 1, now(), now());

/* user_order_review */
INSERT INTO user_order_review (id, user_order_id, review_at, review, create_at, update_at) VALUES (1, 4, '2020-02-03 17:30:00', 'review text', now(), now());

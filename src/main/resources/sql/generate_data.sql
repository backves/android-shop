-- user
insert into android_shop.user (user_id, username, nickname, password, email, phone, avatar, address_id, create_time, update_time) values (1, 'sly_BDOjxEQJX4SsKrOs', null, 'e10adc3949ba59abbe56e057f20f883e', null, '18716890907', '', null, '2023-12-09 09:11:19', '2023-12-09 09:11:19');
insert into android_shop.user (user_id, username, nickname, password, email, phone, avatar, address_id, create_time, update_time) values (2, 'sly_ZBaM4FmGQQZvnz6e', null, 'e10adc3949ba59abbe56e057f20f883e', null, '18716890908', '', null, '2023-12-09 09:11:25', '2023-12-09 09:11:25');
insert into android_shop.user (user_id, username, nickname, password, email, phone, avatar, address_id, create_time, update_time) values (3, 'sly_HdN8UZIfnGK92uxV', null, 'e10adc3949ba59abbe56e057f20f883e', null, '18716890909', '', null, '2023-12-09 09:11:30', '2023-12-09 09:11:30');

-- img
insert into android_shop.img (img_id, url, create_time) values (1, 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/169402/2/41442/96357/64f93ce3Fc5768635/b1f41b777500a4e2.jpg.avif', '2023-12-09 09:22:33');
insert into android_shop.img (img_id, url, create_time) values (2, 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/72910/2/24288/116880/637f2e09E4200b91d/db094edb32a031ec.jpg.avif', '2023-12-09 09:22:45');
insert into android_shop.img (img_id, url, create_time) values (3, 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/59150/5/22399/83355/637f2e08E18d0a8f9/f2b92b7b6f99950c.jpg.avif', '2023-12-09 09:23:16');
insert into android_shop.img (img_id, url, create_time) values (4, 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/119466/12/28216/166208/637f2f16E1ab0c32f/99da4e0c6e2b4353.jpg.avif', '2023-12-09 09:24:37');
insert into android_shop.img (img_id, url, create_time) values (5, 'https://img14.360buyimg.com/n1/jfs/t1/232675/19/5217/215128/65694911F9e5ba501/b0ea29268b27e0d4.jpg.avif', '2023-12-09 09:25:18');
insert into android_shop.img (img_id, url, create_time) values (6, 'https://img14.360buyimg.com/n1/jfs/t1/98433/14/40703/202817/64a69a16Ff3704da9/c87909537274398d.jpg.avif', '2023-12-09 09:25:42');
insert into android_shop.img (img_id, url, create_time) values (7, 'https://img14.360buyimg.com/n1/jfs/t1/144122/8/32921/147200/6469e89dFe99cb6a1/aa27a98c54295ded.jpg.avif', '2023-12-09 09:25:51');
insert into android_shop.img (img_id, url, create_time) values (8, 'https://img14.360buyimg.com/n1/jfs/t1/111017/38/21265/153981/6469e8a5F8ccbd093/a32921149fb24c50.jpg.avif', '2023-12-09 09:25:58');
insert into android_shop.img (img_id, url, create_time) values (9, 'https://img14.360buyimg.com/n1/jfs/t1/177251/1/27595/113355/63219cf6E060606be/5e1599473db75c04.jpg.avif', '2023-12-09 09:26:08');
insert into android_shop.img (img_id, url, create_time) values (10, 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/227049/24/7143/55160/6572d976F7c22b22d/6defa5b7907df9c4.jpg.avif', '2023-12-09 09:27:12');

-- goods
insert into android_shop.goods (goods_id, user_id, name, price, img, detail, type, state, create_time, update_time) values (1, 1, '品胜 手机支架桌面', 18.90, 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/119466/12/28216/166208/637f2f16E1ab0c32f/99da4e0c6e2b4353.jpg.avif', '品胜 手机支架桌面 直播网课便携可折叠旋转 床头懒人支架 通用于华为苹果iphone安卓小米手机架 白色', '卖', 1, '2023-12-09 09:17:12', '2023-12-09 09:17:12');
insert into android_shop.goods (goods_id, user_id, name, price, img, detail, type, state, create_time, update_time) values (2, 1, '二手自行车', 273.00, 'https://img14.360buyimg.com/n1/jfs/t1/232675/19/5217/215128/65694911F9e5ba501/b0ea29268b27e0d4.jpg.avif', 'EG7山地自行车成人学生变速越野单车双减震赛车26寸青少年男女 顶配-钢架黑白色【辐条轮】 26寸21速', '卖', 1, '2023-12-09 09:17:52', '2023-12-09 09:17:52');
insert into android_shop.goods (goods_id, user_id, name, price, img, detail, type, state, create_time, update_time) values (3, 1, '华为HUAWEI MatePad', 2199.00, 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/227049/24/7143/55160/6572d976F7c22b22d/6defa5b7907df9c4.jpg.avif', '华为HUAWEI MatePad 11英寸2023款 120Hz高刷全面屏鸿蒙HarmonyOS 影音娱乐学习平板电脑8+128GB WIFI曜石黑', '卖', 1, '2023-12-09 09:18:55', '2023-12-09 09:18:55');
insert into android_shop.goods (goods_id, user_id, name, price, img, detail, type, state, create_time, update_time) values (4, 2, '懒人床上支架', 58.90, 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/229039/7/3988/63616/655db033F5f63c643/b4ca070981cca37e.jpg.avif', '悬臂支架平板手机支架懒人床上支架ipad网课桌面俯拍直播支撑架设备Switch通用【4-12.9英寸设备】', '卖', 1, '2023-12-09 09:21:04', '2023-12-09 09:28:35');
insert into android_shop.goods (goods_id, user_id, name, price, img, detail, type, state, create_time, update_time) values (5, 2, 'QCY H3', 199.00, 'https://img14.360buyimg.com/n1/s450x450_jfs/t1/226891/21/5238/58546/6568587cF1442d0a3/751317fdba648098.jpg.avif', 'QCY H3 主动降噪 头戴蓝牙耳机重低音无线耳麦手机听力超长待机适用于全手机通用 黑色', '卖', 1, '2023-12-09 09:21:42', '2023-12-09 09:21:42');

-- goods_img
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (1, 1, 1, '2023-12-09 09:23:53');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (2, 1, 2, '2023-12-09 09:23:53');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (3, 1, 3, '2023-12-09 09:23:53');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (4, 1, 4, '2023-12-09 09:24:56');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (5, 2, 5, '2023-12-09 09:26:35');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (6, 2, 6, '2023-12-09 09:26:35');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (7, 2, 7, '2023-12-09 09:26:35');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (8, 2, 8, '2023-12-09 09:26:35');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (9, 2, 9, '2023-12-09 09:26:35');
insert into android_shop.goods_img (g_img_id, goods_id, img_id, create_time) values (10, 3, 10, '2023-12-09 09:28:01');

-- favorite
insert into android_shop.favorite (favorite_id, user_id, goods_id, state, create_time, update_time) values (2, 2, 3, 1, '2023-12-09 09:57:59', '2023-12-09 09:57:59');

-- chat
insert into android_shop.chat (chat_id, seller_id, buyer_id, goods_id, create_time) values (1, 1, 2, 3, '2023-12-09 09:56:25');

-- chat_message
insert into android_shop.chat_message (chat_message_id, chat_id, sender_id, receiver_id, content, type, create_time) values (1, 1, 2, 1, '你好', 0, '2023-12-09 09:56:25');


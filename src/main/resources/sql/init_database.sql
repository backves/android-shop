create database android_shop;

use android_shop;

-- 用户
create table user
(
    user_id     bigint unsigned not null primary key auto_increment,
    username    varchar(20)     not null unique,
    nickname    varchar(20)              default null,
    password    varchar(32)     not null,
    email       varchar(50)              default null,
    phone       varchar(11)     not null unique,
    avatar      varchar(255)    not null default '',
    create_time timestamp       not null default current_timestamp,
    update_time timestamp       not null default current_timestamp on update current_timestamp
);

-- 商品
-- type('买' / '卖')
-- state(0: 已删除 1: 正常 2：已售完)
create table goods
(
    goods_id    bigint unsigned not null auto_increment primary key,
    user_id     bigint unsigned not null,
    name        varchar(255)    not null,
    price       decimal(10, 2)  not null,
    img         varchar(255)    not null,
    detail      varchar(500)    not null,
    type        varchar(5)      not null,
    state       tinyint(1)      not null default 1,
    create_time timestamp       not null default current_timestamp,
    update_time timestamp       not null default current_timestamp on update current_timestamp,
    constraint fk_goods_user foreign key (user_id) references user (user_id)
);

-- 商品评价
create table comment
(
    comment_id  bigint unsigned not null auto_increment primary key,
    user_id     bigint unsigned not null,
    goods_id    bigint unsigned not null,
    content     varchar(255)    not null,
    praise      tinyint(1)      not null default 3,
    create_time timestamp       not null default current_timestamp,
    update_time timestamp       not null default current_timestamp on update current_timestamp,
    constraint fk_comment_user foreign key (user_id) references user (user_id),
    constraint fk_comment_goods foreign key (goods_id) references goods (goods_id)
);

-- 图片
create table img
(
    img_id      bigint unsigned not null auto_increment primary key,
    url         varchar(255)    not null,
    create_time timestamp       not null default current_timestamp
);

-- 商品图片
-- 一个商品最多 5 张图片
create table goods_img
(
    g_img_id    bigint unsigned not null auto_increment primary key,
    goods_id    bigint unsigned not null,
    img_id      bigint unsigned not null,
    create_time timestamp       not null default current_timestamp,
    constraint fk_goods_img_goods foreign key (goods_id) references goods (goods_id),
    constraint fk_goods_img_img foreign key (img_id) references img (img_id)
);


-- 订单
-- 订单状态(待同意 -> 待支付 -> 待发货 -> 待收货 -> 已收货 -> 已完成)
--                       -> 已取消
--              -> 已拒绝
create table `order`
(
    order_id    bigint unsigned not null auto_increment primary key,
    seller_id   bigint unsigned not null,
    buyer_id    bigint unsigned not null,
    goods_id    bigint unsigned not null,
    price       decimal(10, 2)  not null,
    state       tinyint(1)      not null default 1,
    name        varchar(255)    not null,
    phone       varchar(11)     not null,
    location    varchar(50)     not null,
    detail      varchar(255)    not null,
    create_time timestamp       not null default current_timestamp,
    update_time timestamp       not null default current_timestamp on update current_timestamp,
    constraint fk_order_seller foreign key (seller_id) references user (user_id),
    constraint fk_order_buyer foreign key (buyer_id) references user (user_id),
    constraint fk_order_goods foreign key (goods_id) references goods (goods_id)
);

-- 收藏
-- state(0：已失效 1：正常)
create table favorite
(
    favorite_id bigint unsigned not null auto_increment primary key,
    user_id     bigint unsigned not null,
    goods_id    bigint unsigned not null,
    state       tinyint(1)      not null default 1,
    create_time timestamp       not null default current_timestamp,
    update_time timestamp       not null default current_timestamp on update current_timestamp,
    constraint fk_favorite_user foreign key (user_id) references user (user_id),
    constraint fk_favorite_goods foreign key (goods_id) references goods (goods_id)
);

-- 地址
create table address
(
    address_id  bigint unsigned not null auto_increment primary key,
    user_id     bigint unsigned not null,
    name        varchar(255)    not null,
    phone       varchar(11)     not null,
    location    varchar(20)     not null,
    detail      varchar(255)    not null,
    create_time timestamp       not null default current_timestamp,
    update_time timestamp       not null default current_timestamp on update current_timestamp,
    constraint fk_address_user foreign key (user_id) references user (user_id)
);

-- 浏览历史
-- 上限 200 条
create table history
(
    history_id  bigint unsigned not null auto_increment primary key,
    user_id     bigint unsigned not null,
    goods_id    bigint unsigned not null,
    create_time timestamp       not null default current_timestamp,
    constraint fk_history_user foreign key (user_id) references user (user_id),
    constraint fk_history_goods foreign key (goods_id) references goods (goods_id)
);

-- 聊天
create table chat
(
    chat_id     bigint unsigned not null auto_increment primary key,
    seller_id   bigint unsigned not null,
    buyer_id    bigint unsigned not null,
    goods_id    bigint unsigned not null,
    create_time timestamp       not null default current_timestamp,
    constraint fk_chat_seller foreign key (seller_id) references user (user_id),
    constraint fk_chat_buyer foreign key (buyer_id) references user (user_id),
    constraint fk_chat_goods foreign key (goods_id) references goods (goods_id)
);

-- 聊天消息
-- type(0：一般消息 1：订单消息 2：系统消息 3：图片消息)
create table chat_message
(
    chat_message_id bigint unsigned not null auto_increment primary key,
    chat_id         bigint unsigned not null,
    content         varchar(255)    not null,
    type            tinyint(1)      not null default 1,
    create_time     timestamp       not null default current_timestamp,
    constraint fk_chat_message_seller foreign key (chat_id) references chat (chat_id)
);

-- 商品留言
create table message
(
    message_id  bigint unsigned not null auto_increment primary key,
    user_id     bigint unsigned not null,
    goods_id    bigint unsigned not null,
    reply_id    bigint unsigned          default null,
    content     varchar(255)    not null,
    praise      int             not null default 0,
    create_time timestamp       not null default current_timestamp,
    constraint fk_message_user foreign key (user_id) references user (user_id),
    constraint fk_message_goods foreign key (goods_id) references goods (goods_id),
    constraint fk_message_reply foreign key (reply_id) references message (message_id)
);
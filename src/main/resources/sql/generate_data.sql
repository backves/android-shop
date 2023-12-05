SELECT chat.*,
       user.username,
       user.avatar,
       goods.name,
       goods.img,
       goods.price,
       clm.content     as last_message,
       clm.create_time as last_time
FROM chat
         INNER JOIN user ON chat.seller_id = user.user_id
         INNER JOIN goods ON chat.goods_id = goods.goods_id
         INNER JOIN (SELECT chat_message.content, chat_message.chat_id, chat_message.create_time
                     FROM chat_message
                     GROUP BY chat_message_id
                     ORDER BY create_time DESC
                     LIMIT 1) as clm
                    on clm.chat_id = chat.chat_id
WHERE (chat.buyer_id = 2
    or chat.seller_id = 2)
ORDER BY create_time DESC
LIMIT 0, 20;
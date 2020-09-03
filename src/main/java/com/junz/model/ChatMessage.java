package com.junz.model;

/**
 * Created By Junz on 2020/9/2.
 */
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

/*
* 实体中，有三个字段：

type:消息类型
content：消息内容
sender：发送者
类型有三种：

CHAT: 消息
JOIN：加入
LEAVE：离开
* */

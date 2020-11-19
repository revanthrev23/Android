package com.example.texts.ModelClasses

class Chat {
    private var sender: String = ""
    private var message: String = ""
    private var receiever: String = ""
    private var isSeen = false
    private var url: String = ""
    private var messageId: String = ""

    constructor()

    constructor(
        sender: String,
        message: String,
        receiever: String,
        isSeen: Boolean,
        url: String,
        messageId: String
    ) {
        this.sender = sender
        this.message = message
        this.receiever = receiever
        this.isSeen = isSeen
        this.url = url
        this.messageId = messageId
    }

    fun getSender(): String? {
        return sender
    }

    fun setSender(sender: String?){
        this.sender = sender!!
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?){
        this.message = message!!
    }

    fun getReceiever(): String? {
        return receiever
    }

    fun setReceiever(receiever: String?){
        this.receiever = receiever!!
    }

    fun isIsSeen(): Boolean {
        return isSeen
    }

    fun setIsSeen(isSeen: Boolean?){
        this.isSeen = isSeen!!
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?){
        this.url = url!!
    }

    fun getMessageId(): String? {
        return messageId
    }

    fun setMessageId(messageId: String?){
        this.messageId = messageId!!
    }

}
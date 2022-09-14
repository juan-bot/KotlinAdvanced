package com.example.profile.presentation.presenter

enum class TypeChat(val value: Int) {
    MESSAGE_SENT(0),
    MESSAGE_RECEIVED(1),
    VOICE_SENT(2),
    VOICE_RECEIVED(3),
    IMAGE_SENT(4),
    IMAGE_RECEIVED(5),
    DOC_SENT(6),
    DOC_RECEIVED(7),
}
data class Chat(
    val type: TypeChat,
    val message: String,
    val date: String,
    var checked: Boolean
)

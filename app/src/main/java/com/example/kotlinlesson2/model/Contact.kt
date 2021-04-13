package com.example.kotlinlesson2.model

class Contact {
    var name: String? = null
    var phone: String? = null
    var image: String? = null
    var code: String? = null

}

data class Member(
    var name: String? = null,
    var phone: String? = null,
    var isFriend: Boolean? = null
)
package com.social.sanyog.models

data class PhoneAuthUser(
    val userId: String = "",
    val phoneNumber: String = "",
    val name: String = "",
    val status: String = "",
    val profileImage: String? = null
)

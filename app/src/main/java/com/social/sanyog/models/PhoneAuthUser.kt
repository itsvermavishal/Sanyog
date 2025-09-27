package com.social.sanyog.models

data class PhoneAuthUser(
    val userId: String = "",
    val phoneNumber: String = "",
    val name: String = "",
    val staus: String = "",
    val profileImage: String? = null
)

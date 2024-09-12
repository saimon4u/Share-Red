package com.example.sharered.authentication.domain.model

data class Donor(
    val name: String = "",
    val userid: String = "",
    val email: String,
    val password: String = "",
    val number: String = "",
    val bloodGroup: String = "",
    val location: String = "",
    val lat: Double = 0.0,
    val long: Double = 0.0,
    val lastDonated: String = "",
    val isAvailable: Boolean = true,
    val photoLink: String = ""
)
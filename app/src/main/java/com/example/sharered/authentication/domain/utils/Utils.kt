package com.example.sharered.authentication.domain.utils


class InvalidCredentialException(message: String): Exception(message)

object EmailRegex{
    val Gmail = Regex("^[a-zA-Z0-9._%+-]+@gmail\\.com\$\n")
    val IITMail = Regex("^[a-zA-Z0-9._%+-]+@iit\\.du\\.ac\\.bd\$\n")
}
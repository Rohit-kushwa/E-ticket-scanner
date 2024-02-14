package com.example.ticketscanner.dataModel

data class LoginModel(
    val appVersion: String,
    val monumentNameId: String,
    val password: String,
    val rememberMe: Boolean,
    val username: String,
    val id: String,
    val loginStatus: Boolean
)
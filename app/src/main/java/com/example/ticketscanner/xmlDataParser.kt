package com.example.ticketscanner

import com.example.ticketscanner.dataModel.LoginModel
import javax.xml.parsers.DocumentBuilderFactory

fun xmlDataParser(xmlData: String): List<LoginModel> {
    val documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    val inputSource = org.xml.sax.InputSource(java.io.StringReader(xmlData))
    val document = documentBuilder.parse(inputSource)

    val nodeList = document.getElementsByTagName("LoginModel")
    val loginModels = mutableListOf<LoginModel>()

    for (i in 0 until nodeList.length) {
        val node = nodeList.item(i) as org.w3c.dom.Element
        val appVersion = node.getElementsByTagName("AppVersion").item(0).textContent
        val monumentNameId = node.getElementsByTagName("MONUMENTNAME_ID").item(0).textContent
        val password = node.getElementsByTagName("PASSWORD").item(0).textContent
        val rememberMe = node.getElementsByTagName("Rememberme").item(0).textContent.toBoolean()
        val username = node.getElementsByTagName("USERNAME").item(0).textContent
        val id = node.getElementsByTagName("id").item(0).textContent
        val loginStatus = node.getElementsByTagName("loginStatus").item(0).textContent.toBoolean()

        val loginModel = LoginModel(
            appVersion = appVersion,
            monumentNameId = monumentNameId,
            password = password,
            rememberMe = rememberMe,
            username = username,
            id = id,
            loginStatus = loginStatus
        )
        loginModels.add(loginModel)
    }
    return loginModels
}

package com.example.instagram1.login.data

class LoginRepository(private val dataSource: LoginDataSource) {

    fun login(email:String,password:String,callback: LoginCallback){
        //Responsavel com o que fazer com esse dados
        //Vai chamar servidor ou banco de dados locais
        //Salvamento local de algum dado

        dataSource.login(email,password,callback)

    }
}
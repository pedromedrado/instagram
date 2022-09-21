package Register.view.data

class RegisterRepository(private val dataSource: RegisterDataSource) {

    fun create(email: String, callback: RegisterCallback){
        //Responsavel com o que fazer com esse dados
        //Vai chamar servidor ou banco de dados locais
        //Salvamento local de algum dado

        dataSource.create(email,callback)

    }
    fun create(email: String, name: String, password:String, callback: RegisterCallback) {

        dataSource.create(email,name, password,callback,)
    }
}
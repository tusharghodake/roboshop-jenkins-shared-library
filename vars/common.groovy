def compile(){
    if(app_lang == 'nodejs'){
        sh "pm install"
    }

    if(app_lang == 'maven'){
        sh "./mvn clean compile package"
    }

}
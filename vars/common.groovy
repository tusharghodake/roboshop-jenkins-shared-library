def compile(){
    if(app_lang == 'nodejs'){
        sh "npm install"
    }

    if(app_lang == 'maven'){
        sh "mvn package"
    }

}

def unittests(){
    if(app_lang == 'nodejs'){
        //Developer is missing test cases in our project, He need to add then as a best practice, we are skipping to proceed further
        sh "npm test || true"
    }

    if(app_lang == 'maven'){
        sh "mvn test"
    }

    if(app_lang == 'python'){
        sh "python3 -m unittest"
    }
}
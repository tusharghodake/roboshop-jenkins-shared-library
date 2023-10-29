def call(){
pipeline{

    agent  {
        label 'server'
    }
    stages{

        stage('compile/build'){
            steps{
                script{
                    common.compile
                }
            }
        }

        stage('Unit Tests'){
            steps{
                echo 'Unit Tests'
            }
        }

        stage('Quality Control'){
            steps{
                echo 'Quality Control'
            }
        }

        stage('Upload Code to centralized place'){
            steps{
                echo 'Upload'
            }
        }

    }
}
}
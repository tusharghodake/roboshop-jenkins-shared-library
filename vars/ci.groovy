def call() {

    try {
        pipeline {

            agent {
                label 'workstation2'
            }
            stages {

                stage('Compile/Build') {
                    steps {
                        script {
                            common.compile()
                        }
                    }
                }

                stage('Unit Tests') {
                    steps {
                        script {
                            common.unittests()
                        }
                    }
                }

                stage('Quality Control') {
                    steps {
                        echo 'Quality Control'
                    }
                }

                stage('Upload Code to centralized place') {
                    steps {
                        echo 'Upload'
                    }
                }

            }
        }
    } catch (Exception e) {
        common.email("Failed")
    }
}
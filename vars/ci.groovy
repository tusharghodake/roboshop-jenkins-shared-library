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

                        SONAR_PASS = '$(aws ssm get-parameters --region us-east-1 --names sonarqube.pass  --with-decryption --query Parameters[0].Value | sed \'s/"//g\')'
                        SONAR_USER = '$(aws ssm get-parameters --region us-east-1 --names sonarqube.user  --with-decryption --query Parameters[0].Value | sed \'s/"//g\')'
                        wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: "${SONAR_PASS}", var: 'SECRET']]]){
                            echo "echo sonar scan"
                        }

                    steps {
                        sh "sonar-scanner -Dsonar.host.url=http://54.162.159.114:9000 -Dsonar.login=${SONAR_USER} -Dsonar.password=${SONAR_PASS} -Dsonar.projectKey=cart"

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
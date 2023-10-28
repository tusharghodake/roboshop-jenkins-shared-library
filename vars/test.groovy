def call() {
    pipeline {
        agent {
            label 'workstation'
        }
        stages {

            stage('compile/build') {

                steps {

                    script {

                        env.envvar = "environment variable"

                        env.id = 10
                        def Name = "Tushar"

                        print "id: ${id}"
                        print "name: ${Name}"
                    }

                    script{

                        print "id: ${id}"

                    }
                }
            }
            stage('Stage2'){

                steps{
                    script{

                        print "id: ${id}"

                    }
                }

            }
        }
    }
}
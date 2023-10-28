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

                        def id = 10
                        def Name = "Tushar"

                        print "id: ${id}"
                        print "name: ${Name}"
                    }
                    script {

                        print "name: ${Name}"
                        print "envvar :${envvar}"
                    }
                }
            }
        }
    }
}
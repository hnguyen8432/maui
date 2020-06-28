pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "**************** Hung: This is Build Step "'
                sh '''
                    echo "******************Hung: Do listing"
                    ls -lah
                '''
            }
        }
    }
}
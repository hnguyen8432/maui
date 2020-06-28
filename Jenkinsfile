pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            sh 'echo "Hello World 1-Build"'
            sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
          }
        }

        stage('') {
          steps {
            sh 'Echo "TATATA"'
          }
        }

      }
    }

    stage('error') {
      steps {
        echo 'Hello 2 '
      }
    }

  }
}
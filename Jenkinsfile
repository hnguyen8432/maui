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

        stage('error') {
          steps {
            sh 'echo "TATATA"'
          }
        }

      }
    }

    stage('Ending') {
      steps {
        echo 'This is "The End"'
      }
    }

  }
}
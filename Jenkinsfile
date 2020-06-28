pipeline {
  agent any
  stages {
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
        echo 'Hello 2 '
      }
    }

  }
}
pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            sh 'echo "****************Hung: this is build stage"'
            sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
          }
        }

        stage('error') {
          steps {
            sh 'echo "************Hung: Error path"'
          }
        }

      }
    }

    stage('Ending') {
      steps {
        echo 'This is "************** HUng: ending"'
      }
    }

  }
}
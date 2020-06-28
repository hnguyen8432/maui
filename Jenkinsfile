pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            sh 'mvn clean install'
            sh '''
                    echo "****************Hung: this is build stage"'''
            sh '''echo "Multiline shell steps works too"
                    ls -lah
                '''
          }
        }

        stage('Build Plus') {
          steps {
            sh 'echo "************Hung: Build Plus"'
          }
        }

        stage('Build Plus Plus') {
          steps {
            echo '******************** Hung: Build Plus Plus'
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
pipeline {
    agent any
      tools {
        maven 'localMaven'
    }
    stages{
        stage('Build'){
            steps {
                sh 'clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }

            }
        }
    }
}



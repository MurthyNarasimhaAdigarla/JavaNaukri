pipeline {
    agent any
    triggers {
        cron('H/30 * * * *')  // every 30 minutes
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/MurthyNarasimhaAdigarla/JavaNaukri.git'
            }
        }
       stage('Upload Resume') {
           steps {
               bat 'java -jar target/ResumeUploader.jar'
           }
       }

    }
}

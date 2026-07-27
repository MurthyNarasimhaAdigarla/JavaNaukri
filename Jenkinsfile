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
                // Replace with your actual script
                bat 'java -jar ResumeUploader.jar'
                // OR if Python:
                // bat 'python upload_resume.py'
            }
        }
    }
}

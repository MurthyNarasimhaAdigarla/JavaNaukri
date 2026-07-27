pipeline {
    agent any
    triggers {
        cron('H/30 * * * *')  // run every 30 minutes
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/MurthyNarasimhaAdigarla/JavaNaukri.git'
            }
        }
        stage('Build') {
            steps {
                // Maven build step
                bat 'mvn clean test'
            }
        }
        stage('Upload Resume') {
            steps {
                // Run your script that uploads resume to Naukri
                bat 'java -jar ResumeUploader.jar'
                // OR if it’s Python:
                // sh 'python upload_resume.py'
            }
        }
    }
}

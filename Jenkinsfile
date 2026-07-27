pipeline {
    agent any
    triggers {
        cron('H/30 * * * *')  // run every 30 minutes
    }
    tools {
        maven 'Maven_3.9.6'   // configure Maven in Jenkins Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/MurthyNarasimhaAdigarla/JavaNaukri.git'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}

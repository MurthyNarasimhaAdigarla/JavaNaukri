pipeline {
    agent any
    triggers {
        cron('H/2 * * * *')  // run every 2 minutes
    }
    tools {
        maven 'maven'   // must match the name in Global Tool Configuration
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

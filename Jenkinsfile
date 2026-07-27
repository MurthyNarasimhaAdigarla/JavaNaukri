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
        stage('Compile Java') {
            steps {
                bat 'javac NarasimhaNaukriTest.java'
            }
        }
        stage('Run Resume Upload') {
            steps {
                bat 'java NarasimhaNaukriTest'
            }
        }
    }
}

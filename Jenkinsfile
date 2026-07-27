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
        stage('Build with Maven') {
            steps {
                // Build project with Maven
                bat 'mvn clean compile'
            }
        }
        stage('Run Resume Upload') {
            steps {
                // Run the compiled class from target directory
                bat 'java -cp target\\classes com.murthy.tests.NarasimhaNaukriTest'
            }
        }
    }
}

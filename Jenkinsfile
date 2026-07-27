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
                bat 'javac src\\main\\java\\com\\murthy\\tests\\NarasimhaNaukriTest.java'
            }
        }
        stage('Run Resume Upload') {
            steps {
                bat 'java -cp src\\main\\java com.murthy.tests.NarasimhaNaukriTest'
            }
            stage('Run Tests') {
                        steps {
                            bat 'mvn clean test'
                        }
        }
    }
}

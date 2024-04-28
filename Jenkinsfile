pipeline {
    agent any

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    echo 'Installing dependencies...'
                                sh 'brew update'
                                sh 'brew install maven'
                                // OpenJDK 22 yerine mevcut olan OpenJDK sürümünü yükleyin ve JAVA_HOME'u bu sürümün yüklendiği dizine ayarlayın
                                sh 'brew install openjdk@11' // Örnek olarak OpenJDK 11 sürümünü yükleyin
                                env.JAVA_HOME = '/usr/local/opt/openjdk@11' // OpenJDK 11'in yüklendiği dizini belirtin
                                sh 'npm install -g appium'
                }
            }
        }
        stage('Repo Cloning') {
            steps {
                script {
                    echo 'Cloning repository...'
                    git branch: 'main', credentialsId: 'e4c9fc0d-345b-4e30-922c-6adfe86b6541', url: 'https://github.com/hakantetik44/e2e_dejaMobile.git'
                }
            }
        }
        stage('Start Appium Server') {
            steps {
                script {
                    echo 'Starting Appium server...'
                    sh 'appium &'
                    sleep 10
                }
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                script {
                    echo 'Running Cucumber tests...'
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying...'
                }
            }
        }
    }

    post {
        always {
            script {
                echo 'Cleaning up...'

            }
        }
    }
}
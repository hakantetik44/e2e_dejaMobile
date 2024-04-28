pipeline {
    agent any

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    echo 'Installing dependencies...'

                    // JDK 21 kurulumu
                    sh 'brew install openjdk@21'

                    // Maven kurulumu
                    sh 'brew install maven'

                    // Appium kurulumu
                    sh 'npm install -g appium'
                }
            }
        }
        stage('Repo Cloning') {
            steps {
                script {
                    echo 'Cloning repository...'
                    git branch: 'main', url: 'https://github.com/hakantetik44/e2e_dejaMobile.git'
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
        stage('Run Appium Tests') {
            steps {
                script {
                    echo 'Running Appium tests...'

                    // Maven ile testlerin çalıştırılması
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying...'
                    // Deploy işlemleri burada gerçekleştirilebilir, eğer varsa
                }
            }
        }
    }

    post {
        always {
            script {
                echo 'Cleaning up...'

                // Sonuçları temizle
                cleanWs()
            }
        }
    }
}

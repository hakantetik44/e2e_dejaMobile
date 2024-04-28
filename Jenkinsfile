pipeline {
    agent any

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    echo 'Installing dependencies...'

                    // JDK 21 kurulumu
                    sh '''
                        wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz
                        tar -xzf openjdk-11.0.2_osx-x64_bin.tar.gz
                        export JAVA_HOME=$PWD/jdk-11.0.2
                        export PATH=$JAVA_HOME/bin:$PATH
                    '''

                    // Maven kurulumu
                    sh 'wget https://mirror.olnevhost.net/pub/apache/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz'
                    sh 'tar -xzf apache-maven-3.8.4-bin.tar.gz'
                    sh 'export PATH=$PWD/apache-maven-3.8.4/bin:$PATH'

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

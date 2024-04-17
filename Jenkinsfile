pipeline {
    agent any
    stages {
        stage('Build Lembrete') {
            steps {
                build job: 'organice-lembrete', wait: true
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }      
        stage('Build Image') {
            steps {
                script {
                    lembrete = docker.build("alfredjynx/lembrete:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        lembrete.push("${env.BUILD_ID}")
                        lembrete.push("latest")
                    }
                }
            }
        }
    }
}
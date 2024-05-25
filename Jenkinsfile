pipeline {
    agent any

    tools {
        maven 'Maven_3_8_7'  // Replace 'Maven_3_8_7' with the name of your Maven installation in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                //Replace the url with your github account
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-credentials', url: 'https://github.com/Mukezz/CIDemoBlog2.git']]])
            }
        }

        stage('Compile') {
            steps {
                script {
                    sh "mvn clean compile"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh "mvn test"
                }
            }
        }

        stage('Building Jar') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Running Dockerfile to create image') {
            steps {
                script {
                    sh "docker build -t devops/mukeshblogpost3 ."
                }
            }
        }
       

        stage('Starting the application docker container') {
            steps {
                script {
                    sh "docker run -d -p 8080:8080 devops/mukeshblogpost3"
                }
            }
        }              
    }
}

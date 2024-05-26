pipeline {
    agent any

    tools {
        maven 'Maven'  // Replace 'Maven_3_8_7' with the name of your Maven installation in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                //Replace the url with your github account
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-credentials', url: 'https://github.com/MagdyIYounis/jenkins.git']]])
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
                    sh "sudo docker build -t devops/mukeshblogpost3 ."
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

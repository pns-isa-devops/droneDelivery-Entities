pipeline {
    agent any
    tools {
        maven 'Maven-3.6.3'
        jdk 'JDK8'
    }
    stages {
        stage ('Build and Deploy')
        withMaven(
        maven :'Maven-3.6.3',
         globalMavenSettingsConfig: 'Maven settings'){
            steps {
                sh 'mvn clean package deploy'
            }
        }
    }
}
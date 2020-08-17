pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ca612ff9-de94-4787-8cdb-29bc2714977f', url: 'https://github.com/HHHHire/JTest.git']]])
            }
        }
        stage('build') {
            steps {
                bat label: '', script: 'mvn clean package -pl test-service -am'
            }
        }
        stage('deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: '8b71a7e9-c826-492d-9cbb-4667c5ac2b7e', path: '', url: 'http://47.100.88.162:8080')], contextPath: null, onFailure: false, war: 'test-service/target/*.war'
            }
        }
    }
}

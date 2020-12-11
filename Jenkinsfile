pipeline {
    agent any

    tools {
        // Ensure maven36 is configured in global tools.
        maven "maven36"
    }

    stages {
        stage('Init') {
            steps {
                git([url: 'https://github.com/gokulraja2787/trader-common.git', branch: 'master'])
            }

        }
        stage('Quality') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Package') {
            steps {
                sh "mvn -DskipTests=true clean install"
            }
        }
    }
}

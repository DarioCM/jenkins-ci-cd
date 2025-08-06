pipeline{

    agent any

    tools{
        maven "Maven 3.9"
    }

    stages{

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-pat-dario', url: 'https://github.com/DarioCM/jenkins-ci-cd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }

        stage("Build Image"){
          steps{
            script{
              // using unix base so, name and version . means base root
              sh 'docker build -t darioccm/jenkins-cicd:1.0 .'
               //                 user_name_docker_hub/image_name:version .means root level
            }
          }

        }

      /*
        stage("Deploy"){
            steps{
                deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkins-cicd', jar: '**/*.jar'
            }
        }
      */

    }
}
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

        stage("Check Docker Access") {
            steps {
                sh 'which docker'
                sh 'docker --version'
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

         stage("Deploy Image to Docker HUB"){
           steps{
             withCredentials([usernamePassword(credentialsId: 'docker-cred',
               passwordVariable: 'DOCKER_PWD', usernameVariable: 'DOCKER_USER')]) {

               // secure login (no password in args)
               sh 'echo "$DOCKER_PWD" | docker login -u "$DOCKER_USER" --password-stdin'

               // push the same image you built; repo derived from the credential username
               sh 'docker push "$DOCKER_USER"/jenkins-cicd:1.0'
             }
           }
         }

        }



    }
}
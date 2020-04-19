pipeline {
   // dockerhud credentials
   environment {
      registry = "t4techmonkey/devops-docker-repo-0.0.1"
      registryCredential = 'dockerhub'
      dockerImage = ''     
   }

   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      jdk "java-1.8.0-amazon-corretto"
      maven "M3"
   }

   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/shahruk25/devOps.git'

            // Run Maven on a Unix agent.
            sh "mvn -Dmaven.test.failure.ignore=true clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }
         
        //  post {
        //     // If Maven was able to run the tests, even if some of the test
        //     // failed, record the test results and archive the jar file.
        //     success {
        //        junit '**/target/surefire-reports/TEST-*.xml'
        //        archiveArtifacts 'target/*.jar'
        //     }
        //  }
      }

      stage('Building image') {
         steps {
            script {
              dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
         }
      }

      stage('Deploy Image') {
         steps{
            script {
               docker.withRegistry( '', registryCredential ) {
               dockerImage.push()
               }
            }
         }
      }

      stage('Remove Unused docker image') {
         steps{
            sh "docker rmi $registry:$BUILD_NUMBER"
         }
      }
   }
}

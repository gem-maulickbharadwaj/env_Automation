pipeline {
    agent any

 

   tools {
  gradle 'Gradle 8.0.2'
}

 

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/gem-maulickbharadwaj/env_Automation.git'

 

                bat 'gradle clean test'
            }

 

           
        }
      //Stage to get the Build Cause of Jenkins
stage('Build_Cause') {
    def causes = currentBuild.getBuildCauses()
    if (causes) {
      echo "Build cause: ${causes[0].shortDescription}"
  }
  }
    }
}

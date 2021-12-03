//scripted jenkins file

node('master') {
    try {
        properties([
            buildDiscarder(logRotator(daysToKeepStr: '3', numToKeepStr: '3', artifactDaysToKeepStr: '15', artifactNumToKeepStr: '5')),
            disableConcurrentBuilds()
        ])

        stage("Checkout project") {
            echo "Checking out the project"
            try {
                checkout scm
            } catch (Exception e) {
                throw e
            }
        }

        stage("Running testcases") {
            echo "Running the testcases"
            sh "mvn test"
        }

        stage("Bundling project") {
            echo "Bundling the project"
            sh "mvn clean install"
        }

        stage("Deploying to nexus") {
            echo "Deploying the bundled jar to the nexus"
        }

        stage("Sonar analyzer") {
            echo "Running sonar analyzer"
        }

        stage("Running vulnerability check") {
            echo "Running the vulnerability step"
            // sh "mvn dependency-check:aggregate -DsuppressionFile.path=suppressions.xml"
            // sh "mvn dependency-check:aggregate"
        }

        stage("Building docker image") {
            echo "Performing docker setup"
        }

        stage("Tag and publish to hub") {
            echo "Tagging the docker image and pushing it to the hub"
        }

        stage("Removing local image") {
            echo "Clearing the work directory"
        }

        stage("Performing deployment") {
            echo "Performing the deployment"
        }

        stage("Wipe out directory") {
            echo "Wiping out the working directory"
        }

        stage("Post action") {
            echo "Performing the post action step. Setup email or slack notifications"
        }
    }
    catch (Exception e) {
        throw e
    }
}


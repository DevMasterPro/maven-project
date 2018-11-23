pipeline {
    agent any
    tools{
        maven 'localMaven'
    }
        parameters {
         string(name: 'tomcat_uat', defaultValue: '34.240.192.242', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: '54.246.133.89', description: 'Production Server')
    }
    triggers {
        pollSCM('* * * * *')
    }

    stages{

        stage ('build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success{
                    echo 'now archiving the file'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage ('deploy to staging'){
            steps{
                sh 'scp -i  /home/ec2-user/aws-shahin.pem /var/lib/jenkins/workspace/package/webapp/target/webapp.war ec2-user@34.240.192.242:/opt/tomcat/tomcat8/webapps'
            }
            post{
                success{
                    echo 'Deployment to Staging is successfull'
                }
                failure{
                    echo 'Deployment to Staging is a failure'
                }
            }
        }
        stage ('deploy to production'){
            steps{
                    timeout(time:5, unit:'DAYS'){
                        input message:'Approve PRODUCTION Deployment?'
                    }
                sh 'scp -i  /home/ec2-user/aws-shahin.pem /var/lib/jenkins/workspace/package/webapp/target/webapp.war ec2-user@54.246.133.89:/opt/tomcat/tomcat8/webapps'
            }
            post{
                success{
                    echo 'Deployment Successfull into Production'
                }
                failure{

                    echo 'Deployment Failure into Production'
                }
            }
        }
    }
}
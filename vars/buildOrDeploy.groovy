def call(String command) {
      if (command == "build") 
      {
            pipeline {
                  agent any
                   parameters {
        string(name: 'BuildPERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'BuildBIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'BuildTOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'BuildCHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'BuildPASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
                  stages 
                  {
                        stage("Build") 
                        {
                              steps 
                              {
                                    echo "Build is executed"
                                     echo "Hello ${params.BuildPERSON}"

                                     echo "Biography: ${params.BuildBIOGRAPHY}"

                                    echo "Toggle: ${params.BuildTOGGLE}"

                                     echo "Choice: ${params.BuildCHOICE}"

                                     echo "Password: ${params.BuildPASSWORD}"
                              }


                        }     
                  }
            }
      }
      else if(command == "deploy")
      {
            pipeline {
                  agent any
                    parameters {
        string(name: 'DeployPERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'DeployBIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'DeployTOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'DeployCHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'DeployPASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
                  stages 
                  {
                        stage("Deploy") 
                        {
                              steps 
                              {
                                    echo "Deploy is executed"
                                     echo "Hello ${params.DeployPERSON}"

                echo "Biography: ${params.DeployBIOGRAPHY}"

                echo "Toggle: ${params.DeployTOGGLE}"

                echo "Choice: ${params.DeployCHOICE}"

                echo "Password: ${params.DeployPASSWORD}"
                              }
                        }     
                  }
            }     
      }
      else
      {
            pipeline {
                  agent any
                  stages 
                  {
                        stage("Do Nothing") 
                        {
                              steps 
                              {
                                    echo "Doing nothing"
                              }
                        }     
                  }
            }           
      }
}

def call(String command) {
      if (command == "build") 
      {
            pipeline {
                  agent any
                   parameters {
        string(name: 'Build-PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'Build-BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'Build-TOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'Build-CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'Build-PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
                  stages 
                  {
                        stage("Build") 
                        {
                              steps 
                              {
                                    echo "Build is executed"
                                     echo "Hello ${params.Build-PERSON}"

                                     echo "Biography: ${params.Build-BIOGRAPHY}"

                                    echo "Toggle: ${params.Build-TOGGLE}"

                                     echo "Choice: ${params.Build-CHOICE}"

                                     echo "Password: ${params.Build-PASSWORD}"
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
        string(name: 'Deploy-PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'Deploy-BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'Deploy-TOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'Deploy-CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
        
        file(name='Deploy-Myfile', description='This is MyFile')

        password(name: 'Deploy-PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
                  stages 
                  {
                        stage("Deploy") 
                        {
                              steps 
                              {
                                    echo "Deploy is executed"
                                     echo "Hello ${params.PERSON}"

                echo "Biography: ${params.Deploy-BIOGRAPHY}"

                echo "Toggle: ${params.Deploy-TOGGLE}"

                echo "Choice: ${params.Deploy-CHOICE}"

                echo "Password: ${params.Deploy-PASSWORD}"
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

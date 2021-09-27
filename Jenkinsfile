pipeline{

  agent any

  stages{
    stage("Descargar código de la aplicación"){
      steps{
        git "https://github.com/AlmuBlasco/facturas-spring-rest.git"

      }
    }

    stage("Compilar y empaquetar el proyecto"){
      steps{
        script{
          if(isUnix()){
            sh "mvn clean package"

          }else{
            bat "mvn clean package"
          }
        }
      }
    }

    stage("Creación de imagen"){
      steps{
        script{
          if(isUnix()){
              sh "docker build -t ablasco/app-java ."

          }else{
              bat "docker build -t ablasco/app-java ."
          }
        }
      }
    }


    stage("Ejecución de contenedor"){
      steps{
        script{
          if(isUnix()){
            sh "docker run -d --name app-java -p 8081:8080 ablasco/app-java"

          }else{
            bat "docker run -d --name app-java -p 8081:8080 ablasco/app-java"
          }
        }
      }
    }

    stage("Test del servicio"){
      steps{
        echo "Probando servicio"
      }
    }

    stage("Cerrar y eliminar recursos"){
      steps{
        script{
          if(isUnix()){
            sh "docker stop app-java"
            sh "docker container rm app-java"
            sh "docker image rm ablasco/app-java"

          }else{
            bat "docker stop app-java"
            bat "docker container rm app-java"
            bat "docker image rm ablasco/app-java"
          }
        }
      }
    }
  }
}




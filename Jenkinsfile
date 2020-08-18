node {

    stage('拉取代码') {
        steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ca612ff9-de94-4787-8cdb-29bc2714977f', url: 'https://github.com/HHHHire/JTest.git']]])
        }
    }
    stage('编译、构建镜像') {
        // 定义镜像名
        def imageName = "${project_name}:${tag}"

        // 编译
        bat "mvn clean package -pl ${project_name} -am"

        // 构建镜像
        bat "mvn clean package -pl ${project_name} dockerfile:build"
    }

}

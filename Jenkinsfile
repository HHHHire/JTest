// github凭证
def git_auth = "ca612ff9-de94-4787-8cdb-29bc2714977f"
// 构建镜像版本
def tag = "latest"
// harbor地址
def harbor_url = "47.100.88.162:85"
// harbor项目名称
def harbor_project_name = "tensquare"
// harbor凭证
def harbor_auth = "87919adc-2d58-43de-87af-e1f5014e950d"
node {

    stage('pull code') {

        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ca612ff9-de94-4787-8cdb-29bc2714977f', url: 'https://github.com/HHHHire/JTest.git']]])

    }
    stage('build & build image') {
        // 定义镜像名
        def imageName = "${project_name}:${tag}"

        // 编译
        bat "mvn clean package -pl ${project_name} -am"

        // 构建镜像
        bat "mvn clean package -pl ${project_name} dockerfile:build"

        // 该镜像打标签
        bat "docker tag ${imageName} ${harbor_url}/${harbor_project_name}/${imageName}"

        // 登录harbor，并上传镜像
        withCredentials([usernamePassword(credentialsId: '87919adc-2d58-43de-87af-e1f5014e950d', passwordVariable: 'password', usernameVariable: 'username')]) {
            // 登录
            bat "docker login -u ${username} -p ${password} ${harbor_url}"

            // 上传镜像
            bat "docker push ${harbor_url}/${harbor_project_name}/${imageName}"
        }

        // 删除本地镜像
        bat "docker rmi ${imageName}"
        bat "docker rmi ${harbor_url}/${harbor_project_name}/${imageName}"

        // 远程调用，让远程服务器执行shell脚本
        sshPublisher(publishers: [sshPublisherDesc(configName: 'docker_deploy', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '/opt/jenkins_shell/deploy.sh $harbor_url $harbor_project_name $project_name $tag $port', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
    }

}

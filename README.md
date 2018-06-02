# Jenkins with docker

This image allows us to create a Jenkins image fully functional from startup. There is no need to go through the wizard and basic plugins will be installed.

*Username:* _admin_
*Password:* _admin_

### Building the image

The next step helps us create a docker image with the name `jenkins-docker`

> please keep in mind that we need to stand in the folder where our Dockerfile is located

`docker build -t jenkins-docker .`

This will result in an image that can be instantiated to produce containers.

### Running the container

In order to be able to use docker from the Jenkins pipeline, we need to map our local `docker.sock` to the one inside the container. This way Jenkins interacts and uses the local docker.

`docker run -d -p 8081:8080 --name jenkins -v /var/run/docker.sock:/var/run/docker.sock jenkins-docker`

`-d` Run the container in the background
`-p 8081:8080` Mapping our local port 8081 to 8080 inside the container
`--name jenkins` The container produced will be called *jenkins*
`-v` Here we are mapping our local docker.sock to the one in the container

### Plugins

Plugins are installed during the building of the image. They can be located under the `plugins.txt` file following this format:

```
pipeline-input-step:2.8
workflow-durable-task-step:2.19
branch-api:2.0.20
```

> If no version is specified, the latest version will be installed. It is advised to specify versions of plugins that work with the version of Jenkins being used.

### Jobs

All the jobs placed under the `jobs` folder will be automatically loaded when a container is instantiated.

Please keep in mind that this follows Jenkins file based structure of a folder with the job's name, and the `config.xml` inside

*Example*

└─ jobs
│ │
│ └─ my-job-01
│ │ └─ config.xml
│ │
│ └─ my-job-02
│ │ └─ config.xml
│ │
│ └─ ...
└─ ...

Dropping two folders like the ones shown above under the `jobs` folder will create two jobs with the names `my-job-01` and `my-job-02` using the configuration files inside of each.

### Scripts

All the scripts placed under the `groovy` folder will be executed when a container is instantiated.

Security is being configured through the `groovy/conf-security.groovy` script. If we desire to change the credentials it can be modified here.

############################################################
# Dockerfile
# Jenkins Master OSS
############################################################

FROM jenkins/jenkins:2.107.2

USER root

# Installing Docker
RUN apt-get update
RUN apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    git \
    gnupg2 \
    software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
    "deb [arch=amd64] https://download.docker.com/linux/debian \
    $(lsb_release -cs) \
    stable"
RUN apt-get update
RUN apt-get install -y docker-ce

# Skip the wizard
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# Install plugins
COPY plugins.txt /tmp
RUN /usr/local/bin/plugins.sh /tmp/plugins.txt

# Adding groovy scripts to be executed
COPY --chown=jenkins:jenkins groovy /usr/share/jenkins/ref/init.groovy.d

# Adding Jenkins jobs
COPY --chown=jenkins:jenkins jobs /var/jenkins_home/jobs
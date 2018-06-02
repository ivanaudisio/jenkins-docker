import jenkins.model.*
import jenkins.*
import hudson.model.*
import hudson.*

// CONFIGURING JENKINS DEFAULT URL
// Some plugins and functionalities need this in order to work properly
// This is the same as clicking save under Jenkins Configuration

jenkins_url = "http://jenkins:8080"

jlc = JenkinsLocationConfiguration.get()
jlc.setUrl(jenkins_url)
jlc.save()

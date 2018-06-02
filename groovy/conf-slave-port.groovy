import jenkins.model.*
import jenkins.*
import hudson.model.*
import hudson.*

// SETTING JENKINS DEFAULT SLAVE PORT

agent_port = 50000

Jenkins.instance.setSlaveAgentPort(agent_port)

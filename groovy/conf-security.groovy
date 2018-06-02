import jenkins.model.*
import jenkins.*
import hudson.model.*
import hudson.*
import hudson.security.*

def instance = Jenkins.getInstance()

// SET AUTHENTICATION STRATEGY WITH OWN DATABASE AND CREATE USESR

default_user = "admin"
default_password = "admin"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(default_user,default_password)
instance.setSecurityRealm(hudsonRealm)
instance.save()

// SET AUTHORIZATION STRATEGY AND ALLOW ALL AUTHENTICATED USERS
def strategy = new hudson.security.GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER,'authenticated')
instance.setAuthorizationStrategy(strategy)
instance.save()

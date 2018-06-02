import jenkins.model.*
import jenkins.*
import hudson.model.*
import hudson.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*

// ADDING CREDENTIALS WITH SECRET TEXT

// EXAMPLE (uncomment all code below)

// def credentials = [
//     ["id":"cred_secret_01", "desc":"Credential Description", "secret":"secretText"],
//     ["id":"cred_secret_02", "desc":"Credential Description", "secret":"secretText"],
//     ["id":"cred_secret_03", "desc":"Credential Description", "secret":"secretText"],
//     ["id":"cred_secret_04", "desc":"Credential Description", "secret":"secretText"]]
//
// global_domain = Domain.global()
// credentials_store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
//
// credentials.each { credential ->
// 	 cred_id = credential["id"]
//    cred_desc = credential["desc"]
//    cred_text = credential["secret"]
//
//    credential = new org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl(
//       CredentialsScope.GLOBAL,
//     	cred_id,
//     	cred_desc,
//     	new hudson.util.Secret(cred_text))
//   credentials_store.addCredentials(global_domain, credential)
// }
// println "Finished adding secret text credentials"

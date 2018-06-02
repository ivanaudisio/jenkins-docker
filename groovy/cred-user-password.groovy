import jenkins.model.*
import jenkins.*
import hudson.model.*
import hudson.*
import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

// ADDING CREDENTIALS WITH USER AND PASSWORD

// EXAMPLE:

// def credentials = [
//     ["id":"cred_user_01", "desc":"Credential Description", "user":"user01", "pass":"password"],
//     ["id":"cred_user_02", "desc":"Credential Description", "user":"user02", "pass":"password"],
//     ["id":"cred_user_03", "desc":"Credential Description", "user":"user03", "pass":"password"],
//     ["id":"cred_user_04", "desc":"Credential Description", "user":"user04", "pass":"password"]]
//
//
// credentials.each { credential ->
//     cred_id = credential["id"]
//     cred_desc = credential["desc"]
//     cred_user = credential["user"]
//     cred_pass = credential["pass"]
//
//     Credentials newCredential = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,cred_id,cred_desc,cred_user,cred_pass)
//     SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), newCredential)
// }
// println "Finished adding user/password credentials"

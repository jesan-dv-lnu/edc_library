package se.lnu.jesan.library;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial {

    private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {

          log.info("Tracing the Shiro Application");
          log.debug("Trying step 1");
          //1.
          IniRealm iniRealm = new IniRealm("shiro.ini");
          log.debug("Trying step 2");
          //2.
          DefaultSecurityManager securityManager = new DefaultSecurityManager(iniRealm);
          log.debug("Trying step 3");
          //3.
          SecurityUtils.setSecurityManager(securityManager);
        // Step 4: Get the current user (Subject)
        log.debug("Trying step 4");
        Subject currentUser = SecurityUtils.getSubject();
        log.debug("Trying step 5");
        // Step 5: Identification (check if the user is authenticated)
        if (!currentUser.isAuthenticated()) {
            // Step 6: Authentication (login the user)
            log.debug("Trying step 6");
            UsernamePasswordToken token = new UsernamePasswordToken("jesper", "1dv607");
            try {
                currentUser.login(token);
                log.info("User successfully authenticated!");
            } catch (AuthenticationException ae) {
                log.error("Authentication failed: " + ae.getMessage());
                System.exit(1);
            }
        }
        System.exit(0);
    }
}

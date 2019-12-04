package org.bea.bea.service;

import org.bea.bea.model.User;
import org.bea.bea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepo;


    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          return (UserDetails) userRepo.findByUsername(username);
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       return userRepo.findByUsername(username);
//  }

    public boolean addUser(User user) {
        User userFromDb = (User) userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role();
//        role.setName(ROLE_USER);
//        roles.add(role);

        // user.setActive(true);
        /**The randomUUID() method is used to retrieve a type 4 (pseudo randomly generated) UUID.
         * The UUID is generated using a cryptographically strong pseudo random number generator.
         */
       // user.setRoles(Collections.singleton());
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Beautiful Academy. Please, visit next link: http://localhost:4200/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
            // if(this.activateUser(user.getActivationCode())){userRepo.save(user);user.setActive(true);user.setRoles(Collections.singleton(Role.USER));}
        }
        return true;

    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        user.setActive(true);
        userRepo.save(user);
        return true;
    }


}

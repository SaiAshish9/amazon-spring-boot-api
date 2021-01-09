package com.amazon.springapi.services.jwt;

import com.amazon.springapi.entity.user.User;
import com.amazon.springapi.repository.user.UserRepository;
import com.amazon.springapi.utils.MyUserPriciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String x = passwordEncoder.encode("123456");
//        import org.springframework.security.core.userdetails.User;
//        return new User("foo",x,new ArrayList<>());


        User user = userRepository.findByEmail(s);
        System.out.println(user.getUsername() + "\n"+
                user.getEmail()+ "\n" +
                user.getPassword()+"\n");
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }

        return new MyUserPriciple(user);


    }


}

package audit.Authorization.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import audit.Authorization.dao.UserDao;
import audit.Authorization.entity.MyUserDetails;
import audit.Authorization.entity.User;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	private Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername");
		logger.info("loadUserByUsername"+username);

		Optional<User> optionaluserList = userDao.findByUserName(username);
		if(optionaluserList.isPresent()) {
			
			User user=optionaluserList.get();
			logger.info("use",user);
			return new MyUserDetails(user);
		}else {
			throw new UsernameNotFoundException("User not found with username: " + username);

		}
		

	}


}
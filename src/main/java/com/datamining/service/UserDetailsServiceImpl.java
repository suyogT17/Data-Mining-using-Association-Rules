package main.java.com.datamining.service;

import java.util.ArrayList;
import java.util.Collection;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.User;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		UserDetails userDetails  = null;
		User user = new User();
		Criterion crt = Restrictions.eq("username", arg0);
		
		try {
			user = (User) commonDAO.findByCriteriaUniqueResultWithCritera(user, null, crt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		
		userDetails = this.buildUserFromUserEntity(user);
		return userDetails;
	}

	private UserDetails buildUserFromUserEntity(User userEntity) {
		// TODO Auto-generated method stub
		final String username = userEntity.getUsername();
		final String password = userEntity.getPassword();
		final boolean enabled = userEntity.isEnabled();
		final Collection<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		authority.add(new GrantedAuthorityImpl(userEntity.getRole().getRole_name()));
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, enabled, true, true, true, authority);
		return user;
	}

}
 
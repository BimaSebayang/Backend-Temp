package id.co.buara.varia.computama.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class JwtUserDetailsService implements UserDetails {

	

	private static final long serialVersionUID = -5446817407722834700L;
    private String userName;
    private String password;
    private boolean isActive = false;
    private Date firstLogin = new Date();

    Collection<? extends GrantedAuthority> authorities;
	
    public JwtUserDetailsService(String userName, String password) {
		  this.userName = userName;
		  this.password = password;
			  isActive = true;
		  this.authorities = new ArrayList<GrantedAuthority>();
	}
    
    
	
	public Date getFirstLogin() {
		return firstLogin;
	}



	public void setFirstLogin(Date firstLogin) {
		this.firstLogin = firstLogin;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
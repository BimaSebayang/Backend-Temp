package id.co.backend.config;

import id.co.backend.dao.UserTblDao;
import id.co.backend.repository.UserTbl;
import id.co.backend.service.UserTblSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Value("${secret.id}")
	private String secretId;

	@Autowired
	private UserTblSvc userTblSvc;
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		UserTbl userTbl = userTblSvc.getUserTableByUsernameAndPassword(authenticationRequest.getUsername(),authenticationRequest.getPassword());

		authenticate(userTbl.getUsername(),userTbl.getPassword());
		final UserDetails userDetails = new JwtUserDetailsService
				  (userTbl.getUsername(),userTbl.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PutMapping("/logout-app")
	public ResponseEntity<?> logoutAuth(Authentication authentication){
		userTblSvc.logoutData(authentication.getName());
		authentication.setAuthenticated(false);
		return ResponseEntity.ok("Logout sukses");
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}

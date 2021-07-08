package auth.Login.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import java.io.IOException;
import java.util.ArrayList;


public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    private Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        
        logger.info(header);
        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = authenticate(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        token=token.substring(7);

        if (token != null) {
            Claims user = Jwts.parser().setSigningKey(DatatypeConverter
            							.parseBase64Binary("javainuse"))
            						.parseClaimsJws(token).getBody();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }else{
                return  null;
            }

        }
        return null;
    }
}
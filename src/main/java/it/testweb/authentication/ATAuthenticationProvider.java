package it.testweb.authentication;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import it.testweb.domain.entity.Worker;
import it.testweb.repository.WorkerRepository;

@Component
public class ATAuthenticationProvider implements AuthenticationProvider
{
    private Logger log = LogManager.getLogger("application");

    @Autowired
    private WorkerRepository utenteRepository;

    public ATAuthenticationProvider()
    {
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

	List<Worker> listaUtenti = utenteRepository.findByUsername(authentication.getName());

	if (listaUtenti == null || listaUtenti.size() == 0)
	{
	    log.info("Login failed for user '" + authentication.getName() + "'");
	    throw new UsernameNotFoundException(String.format("L'utente con username %s non esiste", authentication.getName()));
	}
	else if (listaUtenti.size() > 1)
	{
	    log.info("Login failed for user '" + authentication.getName() + "'");
	    throw new UsernameNotFoundException(String.format("Attenzione: esistono utenti multipli con l'username %s", authentication.getName()));
	}
	else
	{
	    Worker worker = utenteRepository.findByUsernameAndPassword(authentication.getName(), authentication.getCredentials().toString());

	    if (worker != null)
	    {
		log.info("User '" + authentication.getName() + "' logged in!");

		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
	    }
	    else
	    {
		log.info("Login failed for user '" + authentication.getName() + "'");
	    }

	}

	return null;
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
	return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
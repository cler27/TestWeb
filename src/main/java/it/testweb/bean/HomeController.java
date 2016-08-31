package it.testweb.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String getfirstPage()
    {
	if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)
	{
	    return "login.xhtml";
	}
	else
	{
	    return "auth/home.xhtml";
	}
    }

    public String getContextPath()
    {
	return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
    }
}

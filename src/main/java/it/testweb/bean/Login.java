package it.testweb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import it.testweb.domain.entity.Company;
import it.testweb.repository.CompanyRepository;

@Scope("session")
@Controller(value = "login")
public class Login
{
    private String username = null;
    private String password = null;
    private List<SelectItem> companyList;
    private Long selectedCompanyId;
    private String loggedCompany;

    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    @Autowired
    private CompanyRepository companyRepository;

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public AuthenticationManager getAuthenticationManager()
    {
	return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager)
    {
	this.authenticationManager = authenticationManager;
    }

    public String logoutPage()
    {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

	if (auth != null)
	{
	    new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "/login.xhtml?faces-redirect=true";
    }

    public String getLoggedWorker()
    {
	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public String getLoggedCompany()
    {
	return loggedCompany;
    }

    public boolean isLoggedIn()
    {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	return (auth instanceof AnonymousAuthenticationToken) ? false : true;
    }

    /**
     * @return the companyList
     */
    public List<SelectItem> getCompanyList()
    {
	if (companyList == null || companyList.isEmpty())
	{
	    companyList = new ArrayList<>();

	    List<Company> companies = companyRepository.findAll();

	    for (Company company : companies)
	    {
		companyList.add(new SelectItem(company.getId(), company.toString()));
	    }

	    if (companies.size() == 1)
	    {
		setSelectedCompanyId(companies.get(0).getId());
		Company company = companyRepository.findOne(selectedCompanyId);
		setLoggedCompany(company.getDescription());
	    }
	}
	return companyList;
    }

    /**
     * @param companyList the companyList to set
     */
    public void setCompanyList(List<SelectItem> companyList)
    {
	this.companyList = companyList;
    }

    /**
     * @return the selectedCompanyId
     */
    public Long getSelectedCompanyId()
    {
	return selectedCompanyId;
    }

    /**
     * @param selectedCompanyId the selectedCompanyId to set
     */
    public void setSelectedCompanyId(Long selectedCompanyId)
    {
	this.selectedCompanyId = selectedCompanyId;
	Company company = companyRepository.findOne(selectedCompanyId);
	setLoggedCompany(company.getDescription());
    }

    /**
     * @param loggedCompany the loggedCompany to set
     */
    public void setLoggedCompany(String loggedCompany)
    {
	this.loggedCompany = loggedCompany;
    }

}

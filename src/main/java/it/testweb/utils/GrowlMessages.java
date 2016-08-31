package it.testweb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GrowlMessages
{
    // DONE
    public void doneMessage()
    {
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, Messages.getMessage("done")));
    }

    // INFO
    public void infoMessage(String title, String message)
    {
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }

    public void infoMessage(String message)
    {
	infoMessage(Messages.getMessage("growl_infoTitle"), message);
    }

    // WARN
    public void warnMessage(String title, String message)
    {
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, message));
    }

    public void warnMessage(String message)
    {
	warnMessage(Messages.getMessage("growl_warnTitle"), message);
    }

    // ERROR
    public void errorMessage(String title, String message)
    {
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
    }

    public void errorMessage(String message)
    {
	errorMessage(Messages.getMessage("growl_errorTitle"), message);
    }

    // FATAL
    public void fatalMessage(String title, String message)
    {
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
    }

    public void fatalMessage(String message)
    {
	fatalMessage(Messages.getMessage("growl_fatalTitle"), message);
    }

}

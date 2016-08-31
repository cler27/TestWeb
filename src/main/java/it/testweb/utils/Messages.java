package it.testweb.utils;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class Messages
{
    public static String getMessage(String key)
    {
	return ResourceBundle.getBundle("i18n.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale()).getString(key);
    }
}

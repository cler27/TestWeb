package it.testweb.bean;

import it.testweb.utils.Buttons;
import it.testweb.utils.GrowlMessages;

public class AbstractDetailBean
{
    private Buttons buttons = new Buttons();
    private GrowlMessages growl = new GrowlMessages();

    // GROWL MESSAGE

    // Done
    public void doneMessage()
    {
	growl.doneMessage();
    }

    // Info
    public void infoMessage(String title, String message)
    {
	growl.infoMessage(title, message);
    }

    public void infoMessage(String message)
    {
	growl.infoMessage(message);
    }

    // Warn
    public void warnMessage(String title, String message)
    {
	growl.warnMessage(title, message);
    }

    public void warnMessage(String message)
    {
	growl.warnMessage(message);
    }

    // Error
    public void errorMessage(String title, String message)
    {
	growl.errorMessage(title, message);
    }

    public void errorMessage(String message)
    {
	growl.errorMessage(message);
    }

    // Fatal
    public void fatalMessage(String title, String message)
    {
	growl.fatalMessage(title, message);
    }

    public void fatalMessage(String message)
    {
	growl.fatalMessage(message);
    }

    // Getters&Setters
    /**
     * @return the buttons
     */
    public Buttons getButtons()
    {
	return buttons;
    }

    /**
     * @param buttons the buttons to set
     */
    public void setButtons(Buttons buttons)
    {
	this.buttons = buttons;
    }
}

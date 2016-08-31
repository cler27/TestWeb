package it.testweb.utils;

import java.io.Serializable;

public class Buttons implements Serializable
{
    private static final long serialVersionUID = 3850138884321033527L;

    private Boolean isEditing = Boolean.FALSE;
    
    private Boolean btnClearEnabled;
    private Boolean btnSearchEnabled;
    private Boolean btnNewEnabled;
    private Boolean btnDeleteEnabled;
    private Boolean btnSaveEnabled;

    public Buttons()
    {
	setDefaultButtons();
    }

    public void setDefaultButtons()
    {
	btnClearEnabled = Boolean.TRUE;
	btnSearchEnabled = Boolean.TRUE;
	btnNewEnabled = Boolean.TRUE;
	btnDeleteEnabled = Boolean.FALSE;
	btnSaveEnabled = Boolean.FALSE;
	
	isEditing = Boolean.FALSE;
    }

    public void setEditingButtons()
    {
	btnClearEnabled = Boolean.TRUE;
	btnSearchEnabled = Boolean.FALSE;
	btnNewEnabled = Boolean.FALSE;
	btnDeleteEnabled = Boolean.TRUE;
	btnSaveEnabled = Boolean.TRUE;
	
	isEditing = Boolean.TRUE;
    }

    // Getters&Setters

    /**
     * @return the btnClearEnabled
     */
    public Boolean getBtnClearEnabled()
    {
	return btnClearEnabled;
    }

    /**
     * @param btnClearEnabled the btnClearEnabled to set
     */
    public void setBtnClearEnabled(Boolean btnClearEnabled)
    {
	this.btnClearEnabled = btnClearEnabled;
    }

    /**
     * @return the btnSearchEnabled
     */
    public Boolean getBtnSearchEnabled()
    {
	return btnSearchEnabled;
    }

    /**
     * @param btnSearchEnabled the btnSearchEnabled to set
     */
    public void setBtnSearchEnabled(Boolean btnSearchEnabled)
    {
	this.btnSearchEnabled = btnSearchEnabled;
    }

    /**
     * @return the btnNewEnabled
     */
    public Boolean getBtnNewEnabled()
    {
	return btnNewEnabled;
    }

    /**
     * @param btnNewEnabled the btnNewEnabled to set
     */
    public void setBtnNewEnabled(Boolean btnNewEnabled)
    {
	this.btnNewEnabled = btnNewEnabled;
    }

    /**
     * @return the btnDeleteEnabled
     */
    public Boolean getBtnDeleteEnabled()
    {
	return btnDeleteEnabled;
    }

    /**
     * @param btnDeleteEnabled the btnDeleteEnabled to set
     */
    public void setBtnDeleteEnabled(Boolean btnDeleteEnabled)
    {
	this.btnDeleteEnabled = btnDeleteEnabled;
    }

    /**
     * @return the btnSaveEnabled
     */
    public Boolean getBtnSaveEnabled()
    {
	return btnSaveEnabled;
    }

    /**
     * @param btnSaveEnabled the btnSaveEnabled to set
     */
    public void setBtnSaveEnabled(Boolean btnSaveEnabled)
    {
	this.btnSaveEnabled = btnSaveEnabled;
    }

    /**
     * @return the isEditing
     */
    public Boolean getIsEditing()
    {
	return isEditing;
    }

    /**
     * @param isEditing the isEditing to set
     */
    public void setIsEditing(Boolean isEditing)
    {
	this.isEditing = isEditing;
    }
}

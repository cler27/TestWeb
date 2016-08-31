package it.testweb.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TMP02_UTENTI")
@NoArgsConstructor
@Data
public class Worker implements Serializable
{
    private static final long serialVersionUID = 1261150596621683159L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TMP02_UTENTI")
    private long id;

    @Column(name = "TMP02_USERNAME")
    private String username;

    @Column(name = "TMP02_PASSWORD")
    private String password;

    @Column(name = "TMP02_SCANCODE")
    private String scancode;

    @ManyToOne
    @JoinColumn(name = "TMP02_CODGRUPPO_APV03")
    private Workgroup workgroup;

    /**
     * @return the id
     */
    public long getId()
    {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
	this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
	return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
	this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
	return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
	this.password = password;
    }

    /**
     * @return the workgroup
     */
    public Workgroup getWorkgroup()
    {
	return workgroup;
    }

    /**
     * @param workgroup the workgroup to set
     */
    public void setWorkgroup(Workgroup workgroup)
    {
	this.workgroup = workgroup;
    }

    /**
     * @return the scancode
     */
    public String getScancode()
    {
	return scancode;
    }

    /**
     * @param scancode the scancode to set
     */
    public void setScancode(String scancode)
    {
	this.scancode = scancode;
    }
}

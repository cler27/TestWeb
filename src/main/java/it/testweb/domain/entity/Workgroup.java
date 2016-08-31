package it.testweb.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TMP03_GRUPPI")
@NoArgsConstructor
@Data
public class Workgroup implements Serializable
{
    private static final long serialVersionUID = -4617326563350083282L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TMP03_ID")
    private long id;

    @Column(name = "TMP03_CODICE")
    private String code;

    @Column(name = "TMP03_DESCRIZIONE")
    private String description;

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
     * @return the code
     */
    public String getCode()
    {
	return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code)
    {
	this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
	return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
	this.description = description;
    }

    @Override
    public String toString()
    {
	return this.description;
    }

}

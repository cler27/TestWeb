package it.testweb.bean.worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import it.testweb.domain.entity.Worker;

@Scope("session")
@Controller(value = "workerList")
public class WorkerList
{
    private List<Worker> entities = new ArrayList<Worker>();
    private WorkerDetail detail;
    private Worker selectedEntity;

    public void dblClickSelect(final SelectEvent event)
    {
	Worker worker = (Worker) event.getObject();
	detail.loadEntity(worker);

	try
	{
	    FacesContext.getCurrentInstance().getExternalContext().redirect("workerDetail.xhtml");
	}
	catch (IOException e)
	{
	}
    }

    public void rowSelect(final SelectEvent event)
    {
	setSelectedEntity((Worker) event.getObject());
    }

    public String backAction()
    {
	return "workerDetail";
    }

    public void editAction()
    {
	detail.loadEntity(selectedEntity);

	try
	{
	    FacesContext.getCurrentInstance().getExternalContext().redirect("workerDetail.xhtml");
	}
	catch (IOException e)
	{
	}
    }

    /**
     * @return the entities
     */
    public List<Worker> getEntities()
    {
	return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(List<Worker> entities)
    {
	this.entities = entities;
    }

    /**
     * @return the detail
     */
    public WorkerDetail getDetail()
    {
	return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(WorkerDetail detail)
    {
	this.detail = detail;
    }

    /**
     * @return the selectedEntity
     */
    public Worker getSelectedEntity()
    {
	return selectedEntity;
    }

    /**
     * @param selectedEntity the selectedEntity to set
     */
    public void setSelectedEntity(Worker selectedEntity)
    {
	this.selectedEntity = selectedEntity;
    }
}

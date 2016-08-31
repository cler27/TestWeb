package it.testweb.bean.worker;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import it.testweb.bean.AbstractDetailBean;
import it.testweb.domain.entity.Worker;
import it.testweb.domain.entity.Workgroup;
import it.testweb.repository.WorkerRepository;
import it.testweb.repository.WorkgroupRepository;
import it.testweb.utils.Messages;

@Scope("session")
@Controller(value = "workerDetail")
public class WorkerDetail extends AbstractDetailBean
{
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkgroupRepository workgroupRepository;

    @Autowired
    private WorkerList list;

    private Worker entity = new Worker();
    private String confirmPassword;
    private List<SelectItem> workgroupList;
    private Long selectedWorkgroupId;

    @PostConstruct
    public void init()
    {
	list.setDetail(this);
    }

    public void loadEntity(Worker entity)
    {
	setEntity(entity);
	setConfirmPassword(entity.getPassword());
	getButtons().setEditingButtons();

	if (entity.getWorkgroup() != null)
	{
	    setSelectedWorkgroupId(entity.getWorkgroup().getId());
	}
    }

    public String searchAction()
    {
	List<Worker> entities = (List<Worker>) workerRepository.findAll();

	if (entities != null && entities.size() == 1)
	{
	    loadEntity(entities.get(0));
	}
	else
	{
	    list.setEntities(entities);
	    return "workerList";
	}

	return null;
    }

    public String newAction()
    {
	loadEntity(new Worker());
	return null;
    }

    public String clearAction()
    {
	entity = new Worker();
	setConfirmPassword("");
	getButtons().setDefaultButtons();
	selectedWorkgroupId = null;

	RequestContext.getCurrentInstance().reset("formGenerale");
	return null;
    }

    public String deleteAction()
    {
	workerRepository.delete(entity);
	clearAction();
	return null;
    }

    public String saveAction()
    {
	// Controllo password
	if (!entity.getPassword().equals(confirmPassword))
	{
	    warnMessage(Messages.getMessage("differentPassword"));
	}
	else
	{
	    if (selectedWorkgroupId != null)
	    {
		entity.setWorkgroup(workgroupRepository.findOne(selectedWorkgroupId));
	    }
	    workerRepository.save(entity);
	    doneMessage();
	}

	return null;
    }

    public void checkPassword()
    {
	warnMessage(Messages.getMessage("differentPassword"));
	System.out.println("asd");
    }

    /**
     * @return the entity
     */
    public Worker getEntity()
    {
	return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(Worker entity)
    {
	this.entity = entity;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword()
    {
	return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword)
    {
	this.confirmPassword = confirmPassword;
    }

    /**
     * @return the workgroupList
     */
    public List<SelectItem> getWorkgroupList()
    {
	if (workgroupList == null || workgroupList.isEmpty())
	{
	    workgroupList = new ArrayList<>();

	    List<Workgroup> workgroups = workgroupRepository.findAll();

	    for (Workgroup workgroup : workgroups)
	    {
		workgroupList.add(new SelectItem(workgroup.getId(), workgroup.toString()));
	    }
	}
	return workgroupList;
    }

    /**
     * @param workgroupList the workgroupList to set
     */
    public void setWorkgroupList(List<SelectItem> workgroupList)
    {
	this.workgroupList = workgroupList;
    }

    /**
     * @return the selectedWorkgroupId
     */
    public Long getSelectedWorkgroupId()
    {
	return selectedWorkgroupId;
    }

    /**
     * @param selectedWorkgroupId the selectedWorkgroupId to set
     */
    public void setSelectedWorkgroupId(Long selectedWorkgroupId)
    {
	this.selectedWorkgroupId = selectedWorkgroupId;
    }
}

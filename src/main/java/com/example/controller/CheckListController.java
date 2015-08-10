package com.example.controller;

import com.example.entity.Check;
import com.example.service.CheckService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class CheckListController implements Serializable {

    public static final long serialVersionUID = 1L;

    @ManagedProperty("#{checkService}")
    private CheckService checkService;

    private List<Check> checks;

    private Check check = new Check();

    @PostConstruct
    public void loadChecks() {
        checks = checkService.findAll();
    }

    public void save() {
        checkService.save(check);
        check = new Check();
        checks = checkService.findAll();
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Check saved!", null));
    }

    public void remove(Check check) {
        checkService.remove(check);
        checks = checkService.findAll();
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Check deleted!", null));
    }

    public void clear() {
        check = new Check();
    }
}

package com.lemke.tasklist.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {

  @Id
  @Column(name = "idTask")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idTask;

  private String title;

  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  private String description;

  private Date creationDate;

  private Date endDate;

  public Task() {
  }

  public Task(Long idTask) {
    this.idTask = idTask;
  }

  public Long getIdTask() {
    return idTask;
  }

  public void setIdTask(Long idTask) {
    this.idTask = idTask;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @JsonGetter
  public boolean checked() {
    return status.equals(TaskStatus.FINISHED);
  }

}

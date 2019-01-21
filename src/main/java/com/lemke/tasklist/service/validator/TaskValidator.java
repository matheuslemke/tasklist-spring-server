package com.lemke.tasklist.service.validator;

import com.lemke.tasklist.exception.RequiredFieldNotFilledException;
import com.lemke.tasklist.model.Task;

import static org.springframework.util.StringUtils.isEmpty;

public class TaskValidator {

  public void validateSave(Task task) {
    validateMandatoryFields(task);
  }

  public void validateUpdate(Task task) {
    validateMandatoryFields(task);
    validateIdNotNull(task);
  }

  void validateMandatoryFields(Task task) {
    if (isEmpty(task.getTitle())) {
      throw new RequiredFieldNotFilledException("title");
    }

    if (task.getStatus() == null) {
      throw new RequiredFieldNotFilledException("status");
    }

    if (task.getCreationDate() == null) {
      throw new RequiredFieldNotFilledException("status");
    }
  }

  void validateIdNotNull(Task task) {
    if (task.getIdTask() == null) {
      throw new RequiredFieldNotFilledException("idTask");
    }
  }

}

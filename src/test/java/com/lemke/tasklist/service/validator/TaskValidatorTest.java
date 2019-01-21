package com.lemke.tasklist.service.validator;

import com.lemke.tasklist.exception.RequiredFieldNotFilledException;
import com.lemke.tasklist.model.Task;
import com.lemke.tasklist.model.TaskStatus;
import org.junit.Test;

import java.util.Date;

public class TaskValidatorTest {

  private TaskValidator taskValidator = new TaskValidator();

  @Test(expected = RequiredFieldNotFilledException.class)
  public void deveLancarExcecaoCasoTituloEstejaVazio() {

    Task task = new Task();
    task.setTitle("");
    task.setCreationDate(new Date());
    task.setStatus(TaskStatus.CREATED);
    taskValidator.validateMandatoryFields(task);

  }

  @Test(expected = RequiredFieldNotFilledException.class)
  public void deveLancarExcecaoCasoDataCriacaoEstejaVazia() {

    Task task = new Task();
    task.setTitle("Titulo");
    task.setCreationDate(null);
    task.setStatus(TaskStatus.CREATED);
    taskValidator.validateMandatoryFields(task);

  }

  @Test(expected = RequiredFieldNotFilledException.class)
  public void deveLancarExcecaoCasoStatusEstejaVazio() {

    Task task = new Task();
    task.setTitle("Titulo");
    task.setCreationDate(new Date());
    task.setStatus(null);
    taskValidator.validateMandatoryFields(task);

  }

  @Test
  public void naoDeveLancarExcecaoCasoCamposObrigatoriosForemPreenchidos() {

    Task task = new Task();
    task.setTitle("Titulo");
    task.setCreationDate(new Date());
    task.setStatus(TaskStatus.CREATED);
    taskValidator.validateMandatoryFields(task);

  }

  @Test(expected = RequiredFieldNotFilledException.class)
  public void deveLancarExcecaoCasoIdEstejaNulo() {

    Task task = new Task();
    taskValidator.validateIdNotNull(task);

  }

}
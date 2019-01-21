package com.lemke.tasklist.service;

import com.lemke.tasklist.exception.NotFoundException;
import com.lemke.tasklist.model.Task;
import com.lemke.tasklist.model.TaskStatus;
import com.lemke.tasklist.repository.TaskRepository;
import com.lemke.tasklist.service.validator.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  private TaskValidator taskValidator = new TaskValidator();

  public Collection<Task> getAll() {
    return taskRepository.findAll();
  }

  public Task save(Task task) {
    task.setCreationDate(new Date());
    task.setStatus(TaskStatus.CREATED);

    taskValidator.validateSave(task);
    return taskRepository.save(task);
  }

  public Task get(Long id) {
    return taskRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(id));
  }

  public Task update(Task task) {
    Task savedTask = get(task.getIdTask());

    mapToSavedTask(savedTask, task);

    return saveUpdate(savedTask);
  }

  public void delete(Long id) {
    taskRepository.deleteById(id);
  }

  public Task endTask(Task task) {
    Task savedTask = get(task.getIdTask());

    savedTask.setStatus(TaskStatus.FINISHED);
    savedTask.setEndDate(new Date());

    return saveUpdate(savedTask);
  }

  public Task restartTask(Task task) {
    Task savedTask = get(task.getIdTask());

    savedTask.setStatus(TaskStatus.CREATED);
    savedTask.setEndDate(null);

    return saveUpdate(savedTask);
  }

  private Task saveUpdate(Task savedTask) {
    taskValidator.validateUpdate(savedTask);
    return taskRepository.save(savedTask);
  }

  private void mapToSavedTask(Task savedTask, Task newTask) {

    if (newTask.getStatus() != null) {
      savedTask.setStatus(newTask.getStatus());
    }

    if (newTask.getCreationDate() != null) {
      savedTask.setCreationDate(newTask.getCreationDate());
    }

    if (newTask.getEndDate() != null) {
      savedTask.setEndDate(newTask.getEndDate());
    }

    if (newTask.getTitle() != null) {
      savedTask.setTitle(newTask.getTitle());
    }

    if (newTask.getDescription() != null) {
      savedTask.setDescription(newTask.getDescription());
    }

  }

}

package com.lemke.tasklist.controller;

import com.lemke.tasklist.model.Task;
import com.lemke.tasklist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public Collection<Task> getAll() {
    return taskService.getAll();
  }

  @PostMapping
  public Task post(@RequestBody Task task) {
    return taskService.save(task);
  }

  @GetMapping("{id}")
  public Task get(@PathVariable Long id) {
    return taskService.get(id);
  }

  @PutMapping("{id}")
  public Task put(@RequestBody Task task, @PathVariable Long id) {
    task.setIdTask(id);
    return taskService.update(task);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    taskService.delete(id);
  }

  @PutMapping("{id}/end")
  public Task endTask(@PathVariable Long id) {
    Task task = new Task(id);
    return taskService.endTask(task);
  }

  @PutMapping("{id}/restart")
  public Task restartTask(@PathVariable Long id) {
    Task task = new Task(id);
    return taskService.restartTask(task);
  }

}

package com.lemke.tasklist.repository;

import com.lemke.tasklist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

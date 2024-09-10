package eu.svorada.alex.todo.repositories;

import eu.svorada.alex.todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class TaskRepository implements JpaRepository<Task, Long> {}

package eu.svorada.alex.todo.repositories;

import eu.svorada.alex.todo.models.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface TaskRepository extends JpaRepository<Task, Long> {}

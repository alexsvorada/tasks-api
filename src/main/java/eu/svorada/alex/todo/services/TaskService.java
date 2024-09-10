package eu.svorada.alex.todo.services;

import eu.svorada.alex.todo.models.Task;
import eu.svorada.alex.todo.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  @Autowired
  public TaskService(final TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Transactional
  public void createTask(final Task task) {
    taskRepository.save(task);
  }

  public List<Task> getTasks() {
    return taskRepository.findAll();
  }

  public Task getTask(final Long id) throws EntityNotFoundException {
    return taskRepository.findById(id)
      .orElseThrow(() -> createEntityNotFoundException(id));
  }


  @Transactional
  public void updateTask(final Task task) throws EntityNotFoundException {
    final Long id = task.getId();

    if (!taskRepository.existsById(id)) {
      throw createEntityNotFoundException(id);
    }

    taskRepository.save(task);
  }

  @Transactional
  public void deleteTask(final Long id) throws EntityNotFoundException {
    if (!taskRepository.existsById(id)) {
      throw createEntityNotFoundException(id);
    }

    taskRepository.deleteById(id);
  }

  // DRY
  private EntityNotFoundException createEntityNotFoundException(final Long id) {
    return new EntityNotFoundException("Task with id " + id + " not found");
  }
}

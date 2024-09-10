package eu.svorada.alex.todo.controllers;

import eu.svorada.alex.todo.models.Task;
import eu.svorada.alex.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(final TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody final Task task) {
    taskService.createTask(task);
    return ResponseEntity.status(HttpStatus.CREATED).body(task);
  }

  @GetMapping
  public ResponseEntity<List<Task>> getTasks() {
    final List<Task> tasks = taskService.getTasks();
    return ResponseEntity.ok(tasks);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTask(@PathVariable final Long id) {
    final Task task = taskService.getTask(id);
    return ResponseEntity.ok(task);
  }

  @PutMapping
  public ResponseEntity<Task> updateTask(@RequestBody final Task task) {
    taskService.updateTask(task);
    return ResponseEntity.ok(task);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable final Long id) {
    taskService.deleteTask(id);
    return ResponseEntity.noContent().build();
  }
}

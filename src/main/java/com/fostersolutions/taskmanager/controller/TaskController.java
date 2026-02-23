package com.fostersolutions.taskmanager.controller;

import com.fostersolutions.taskmanager.models.Task;
import com.fostersolutions.taskmanager.payload.request.CreateTaskRequest;
import com.fostersolutions.taskmanager.payload.response.TaskResponseDTO;
import com.fostersolutions.taskmanager.security.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody CreateTaskRequest req) {

        Task task = taskService.createTask(userDetails.getUsername(), req);
        return ResponseEntity.ok(new TaskResponseDTO(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getMyTasks(
            @AuthenticationPrincipal UserDetails userDetails
    ){
        return ResponseEntity.ok(taskService.getTasksForUser(userDetails.getUsername()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTaskCompleted(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long id,
            @RequestBody Map<String, Boolean> body
            ){
        boolean completed = body.getOrDefault("completed", false);

        Task updated = taskService.updateCompleted(
                userDetails.getUsername(), id, completed
        );

        return ResponseEntity.ok(new TaskResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long id
    ){
        taskService.deleteTask(userDetails.getUsername(), id);
        return ResponseEntity.noContent().build();
    }
}

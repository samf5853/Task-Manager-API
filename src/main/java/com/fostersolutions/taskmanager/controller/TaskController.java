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

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CreateTaskRequest req) {
        Task task = taskService.createTask(userDetails.getUsername(), req);
        return ResponseEntity.ok(new TaskResponseDTO(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getMyTasks(
            @AuthenticationPrincipal UserDetails userDetails
    ){
        return ResponseEntity.ok(taskService.getTasksForUser(userDetails.getUsername()));
    }
}

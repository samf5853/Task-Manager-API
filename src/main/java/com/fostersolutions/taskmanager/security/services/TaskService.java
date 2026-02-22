package com.fostersolutions.taskmanager.security.services;

import com.fostersolutions.taskmanager.models.Task;
import com.fostersolutions.taskmanager.models.User;
import com.fostersolutions.taskmanager.payload.request.CreateTaskRequest;
import com.fostersolutions.taskmanager.payload.response.TaskResponseDTO;
import com.fostersolutions.taskmanager.repository.TaskRepository;
import com.fostersolutions.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task createTask(String username, CreateTaskRequest req) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        Task task = new Task();
        task.setTitle(req.title());
        task.setDescription(req.description());
        task.setUser(user);

        return taskRepository.save(task);
    }

    public List<TaskResponseDTO> getTasksForUser(String username){
        return taskRepository.findByUserUsername(username)
                .stream()
                .map(TaskResponseDTO::new)
                .toList();
    }
}

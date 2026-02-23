package com.fostersolutions.taskmanager.payload.response;

import com.fostersolutions.taskmanager.models.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }
}

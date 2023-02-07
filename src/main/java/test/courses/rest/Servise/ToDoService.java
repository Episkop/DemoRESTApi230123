package test.courses.rest.Servise;

import test.courses.rest.Entity.ToDoEntity;
import test.courses.rest.Model.TodoModel;

public interface ToDoService {
    public TodoModel createToDo(ToDoEntity toDoEntity, Long userId);
    public TodoModel completed(Long id);
}

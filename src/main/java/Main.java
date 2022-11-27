import com.taskManager.DTO.Response;
import com.taskManager.controller.TaskController;
import com.taskManager.gui.TaskGui;
import com.taskManager.service.DataService;
import com.taskManager.storage.utillity.HibernateUtil;
import com.taskManager.storage.service.TaskService;
import com.taskManager.storage.entity.Task;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TaskGui()::createAndShow);
    }
}

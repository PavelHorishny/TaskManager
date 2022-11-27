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
    public static void main(String[] args) throws InterruptedException, SQLException {
/*        Task t = new Task();
        t.setName("terr");
        t.setSTime(5);
        t.setCreatedDateTime("lll");
        Task t1 = new Task();
        t1.setName("terr1");
        t1.setSTime(51);
        t1.setCreatedDateTime("lll1");
        DataService dataService = new DataService();
        dataService.resolvePost("newTest1");*/
/*        Task t = new Task();
        t.setName("terr");
        t.setSTime(5);
        t.setCreatedDateTime("lll");*/

/*        TaskController tc = new TaskController();
        Response r = tc.put(3,null,"yes",5);
        System.out.println(r.toString());
        HibernateUtil.shutdown();*/

/*        try {
          ts.getByID(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HibernateUtil.shutdown();*/
        SwingUtilities.invokeLater(new TaskGui()::createAndShow);
    }
}

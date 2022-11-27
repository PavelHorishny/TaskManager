import com.taskManager.gui.TaskGui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TaskGui()::createAndShow);
    }
}

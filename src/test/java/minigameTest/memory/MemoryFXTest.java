package minigameTest.memory;



import application.minigame.memory.MemoryView;
import application.minigame.memory.SecretCode;
import application.minigame.memory.SecretCodeImpl;
import com.sun.glass.ui.Size;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class MemoryFXTest {

    private MemoryView memoryView;

    @Start
    public void start(Stage stage) {
        memoryView = new MemoryView();
        stage = memoryView.getStage();

        stage.showAndWait();
        stage.toFront();
    }

}

package minigametest.memory;



import view.memory.MemoryView;
import javafx.stage.Stage;
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

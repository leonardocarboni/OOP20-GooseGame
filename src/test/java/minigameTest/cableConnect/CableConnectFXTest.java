package minigametest.cableconnect;

import application.minigame.cableconnect.CableConnectView;
import application.minigame.cableconnect.CableColor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class CableConnectFXTest {

    private CableConnectView cableconnect;

    @Start
    public void start() {
        cableconnect = new CableConnectView();
        final Stage mainStage = cableconnect.getStage();
        final CableColor[] colorsArray = { CableColor.RED, CableColor.BLUE, CableColor.YELLOW, CableColor.GREEN };
        cableconnect.initializeButtonsMap(colorsArray, colorsArray);
        cableconnect.initializeStartButtons();
        cableconnect.initializeEndButtons();
        cableconnect.initializeEventHandlers();
        mainStage.show();
        mainStage.toFront();
    }

    /**
     * Tests the basic color to same color connection.
     * 
     * @param robot
     */
    @Test
    public void testRedToRed(final FxRobot robot) {
        final Scene scene = cableconnect.getScene();
        final Button redStart = (Button) scene.lookup("#startButton0");
        final Button redEnd = (Button) scene.lookup("#endButton0");
        // START PHASE: assert that only the "start" buttons are enabled.
        Assertions.assertThat(redEnd.isDisable());
        Assertions.assertThat(!redStart.isDisable());
        // Click on red start button.
        robot.clickOn(redStart);
        // MIDDLE PHASE: assert that the red end button isn't disabled.
        Assertions.assertThat(!redEnd.isDisable());
        // Click on red end button
        robot.clickOn(redEnd);
        // FINAL PHASE: assert that red end button is now disabled.
        Assertions.assertThat(redEnd.isDisable());
    }

    /**
     * Test the connection between two different colors.
     * 
     * @param robot
     */
    @Test
    public void testGreenToBlue(final FxRobot robot) {
        final Scene scene = cableconnect.getScene();
        final Button greenStart = (Button) scene.lookup("#startButton3");
        final Button greenEnd = (Button) scene.lookup("#endButton3");
        final Button blueEnd = (Button) scene.lookup("#endButton1");
        // START PHASE: assert that only the "start" buttons are enabled.
        Assertions.assertThat(blueEnd.isDisable());
        Assertions.assertThat(greenEnd.isDisable());
        Assertions.assertThat(!greenStart.isDisable());
        // Click on the green start button.
        robot.clickOn(greenStart);
        // MIDDLE PHASE: assert that the blue end button is disabled and the green one
        // isn't.
        Assertions.assertThat(blueEnd.isDisable());
        Assertions.assertThat(!greenEnd.isDisable());
        // Click on blue end button [Unsuccessful].
        robot.clickOn(blueEnd);
        // Click on green end button [Successful].
        robot.clickOn(greenEnd);
        // FINAL PHASE: assert that the blue and green end button are disabled.
        Assertions.assertThat(blueEnd.isDisable());
        Assertions.assertThat(greenEnd.isDisable());

    }
}

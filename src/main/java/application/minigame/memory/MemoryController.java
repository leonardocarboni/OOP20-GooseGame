package application.minigame.memory;

import controller.minigame.MinigameController;

public class MemoryController implements MinigameController {

    private final MemoryView view;

    public MemoryController() {
        view = new MemoryView();
        view.show();
    }

    @Override
    public int getResult() {
        return 0;
    }
}

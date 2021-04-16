package view;

public class MinigameView extends View {

    public MinigameView(final ViewType gameType) {
        super.createStage(gameType);
        this.getStage().setOnCloseRequest(e -> e.consume());
    }

    public void showAndWaitResult() {
        this.getStage().showAndWait();
    }
}

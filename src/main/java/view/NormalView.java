package view;

public class NormalView extends View {

    public NormalView(final ViewType gameType) {
        super.createStage(gameType);
    }

    public void show() {
        this.getStage().show();
    }
}

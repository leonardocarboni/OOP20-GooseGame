package controller.howtoplay;

import view.HowToPlayView;

public class HowToPlayImpl implements HowToPlay {

    public void start() {
        final HowToPlayView view = new HowToPlayView();
        view.show();
    }
}

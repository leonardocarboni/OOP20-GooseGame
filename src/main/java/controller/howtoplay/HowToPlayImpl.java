package controller.howtoplay;

import view.HowToPlayView;

public class HowToPlayImpl implements HowToPlay {

    public HowToPlayImpl() {
        final HowToPlayView view = new HowToPlayView();
        view.show();
    }
}

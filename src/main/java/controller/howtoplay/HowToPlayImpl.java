package controller.howtoplay;

import view.HowToPlayView;

public class HowToPlayImpl implements HowToPlay{

    private final HowToPlayView view;

    public HowToPlayImpl() {
        view = new HowToPlayView();
        view.show();
    }
}

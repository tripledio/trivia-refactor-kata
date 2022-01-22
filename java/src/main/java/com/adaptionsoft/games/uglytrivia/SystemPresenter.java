package com.adaptionsoft.games.uglytrivia;

public class SystemPresenter implements Presenter {
    public SystemPresenter() {
    }

    @Override
    public void present(String message) {
        System.out.println(message);
    }
}
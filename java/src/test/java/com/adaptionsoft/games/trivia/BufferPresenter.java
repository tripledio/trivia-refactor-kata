package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Presenter;

import java.util.ArrayList;
import java.util.List;

public class BufferPresenter implements Presenter {
    private final List<String> messages = new ArrayList<>();

    @Override
    public void present(String message) {
        messages.add(message);
    }

    public List<String> getBufferedMessages() {
        return messages;
    }
}

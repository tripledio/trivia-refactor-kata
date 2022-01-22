package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.uglytrivia.Presenter
import java.util.ArrayList

internal class BufferPresenter : Presenter {
    private val messages: MutableList<String> = ArrayList()

    override fun present(message: String) {
        messages.add(message)
    }

    val bufferedMessages: List<String>
        get() = messages
}
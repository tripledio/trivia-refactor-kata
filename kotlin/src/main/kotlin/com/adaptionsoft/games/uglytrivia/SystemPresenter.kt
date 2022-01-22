package com.adaptionsoft.games.uglytrivia

interface Presenter {
    fun present(message: String)
}

class SystemPresenter : Presenter {
    override fun present(message: String) {
        println(message)
    }

}
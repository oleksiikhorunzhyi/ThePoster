package khorunzhyicom.alex.theposter.presentation.common.view

interface ContentView<in T> {

    fun showContent(content: T)

    fun showError(error: String)

    fun showProgress(progress: Int)
}
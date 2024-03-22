package dev.tunnicliff.ui.demo.view.helper

import androidx.navigation.NavController
import dev.tunnicliff.ui.demo.view.navigateToCardDemoView

interface Router {
    fun navigateBack()
    fun navigateToCardDemoView()
}

class RootRouter(private val navController: NavController) : Router {
    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToCardDemoView() {
        navController.navigateToCardDemoView()
    }
}

class PreviewRouter() : Router {
    override fun navigateBack() {}
    override fun navigateToCardDemoView() {}
}

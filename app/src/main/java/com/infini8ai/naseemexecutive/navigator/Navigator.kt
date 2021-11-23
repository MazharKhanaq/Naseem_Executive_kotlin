package com.infini8ai.naseemexecutive.navigator


enum class Screen {

    LOGIN,
    Sign_up,
    HOME,
    SPLASH,
    PRINICIPAL_DASHBAORD,
    Fees,

}

interface Navigator {
    fun navigateTo(screen: Screen, type: Any?)
}
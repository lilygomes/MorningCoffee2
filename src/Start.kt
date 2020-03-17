/*
File: Start.kt
--------------
This exists purely to launch Launcher.kt, but with the Decorated look and feel.
 */


import javax.swing.JFrame

class Start: JFrame() {
    init {
        // Java theme
        setDefaultLookAndFeelDecorated(true)
        Launcher().launcher()
    }
}

fun main() {
    val frame = Start()
    frame.isVisible = true
}
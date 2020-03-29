/*
File: Start.kt
--------------
This exists to launch Launcher.kt with the Decorated look and feel.
This file generates the Applications menu from the conf/applications file
on startup.
This file also passes the prefs array to Launcher.kt, which contains the
preferences read from conf/preferences.
 */


import java.awt.event.ActionEvent
import java.io.File
import java.util.*
import javax.swing.AbstractAction
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem


class Start: JFrame() {
    init {
        // Read the preferences from conf/preferences
        val prefFile = Scanner(File("conf/preferences"))
        // Array to store preferences in
        val prefs = Array<Any>(2){}
        /* Indices:
         * 0: starting X position for Launcher window
         * 1: starting Y position for Launcher window
         */
        // Get starting position for window
        prefs[0] = prefFile.nextInt()
        prefs[1] = prefFile.nextInt()

        // "Applications" menu
        val applicationsMenu = JMenu("Applications")
        // Read file for each application
        val appMenuFile = Scanner(File("conf/applications"))
        while (appMenuFile.hasNextLine()) {
            /* App file format:
             * Name;command
             */
            val app = appMenuFile.nextLine().split(';')
            applicationsMenu.add(JMenuItem(object: AbstractAction(app[0]) {
                // Upon clicking the item, run specified command
                override fun actionPerformed(e: ActionEvent?) {
                    Runtime.getRuntime().exec(app[1])
                }
            }))
        }

        // Java theme
        setDefaultLookAndFeelDecorated(true)
        Launcher(applicationsMenu, prefs).launcher()
    }
}

fun main() {
    Start()
}
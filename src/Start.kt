/*
File: Start.kt
--------------
This exists to launch Launcher.kt with the Decorated look and feel.
This file generates the Applications menu from the mc2/applications file
on startup.
This file also passes the prefs array to Launcher.kt, which contains the
preferences read from mc2/preferences.
 */


import java.awt.event.ActionEvent
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import javax.swing.AbstractAction
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem


class Start: JFrame() {
    init {
        // Read the preferences from mc2/preferences
        val prefFile = try {
            Scanner(File("mc2/preferences"))
        }
        // If mc2/preferences doesn't exist, create it
        catch (e: java.io.FileNotFoundException) {
            println("mc2/preferences not found, generating...")
            // If user does not have permissions to make a folder, quit
            if (!Files.isDirectory(Paths.get("mc2")))
                Files.createDirectory(Paths.get("mc2"))
            val createmc2 = PrintWriter(File("mc2/preferences"))
            createmc2.println(50)
            createmc2.println(50)
            createmc2.close()
            Scanner(File("mc2/preferences"))
        }
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
        val appMenuFile = try {
            Scanner(File("mc2/applications"))
        }
        // If mc2/applications doesn't exist, create it
        catch (e: java.io.FileNotFoundException) {
            println("mc2/applications not found, generating...")
            val createmc2 = PrintWriter(File("mc2/applications"))
            createmc2.close()
            Scanner(File("mc2/applications"))
        }
        // Create submenus
        while (appMenuFile.hasNextLine()) {
            /* App file format:
             * name;command
             * submenu;{
             * name;command
             * }
             * name;command
             */
            var line = appMenuFile.nextLine()
            var app: List<String>
            if (line.contains('{')) {
                // Use the submenu name as all characters before the semicolon
                val submenu = JMenu(line.split(';')[0])
                while (appMenuFile.hasNextLine()) {
                    line = appMenuFile.nextLine()
                    if (line.contains('}')) {
                        applicationsMenu.add(submenu)
                        break
                    }
                    app = line.split(';')
                    submenu.add(JMenuItem(object: AbstractAction(app[0]) {
                        // Upon clicking the item, run specified command
                        override fun actionPerformed(e: ActionEvent?) {
                            Runtime.getRuntime().exec(app[1])
                        }
                    }))
                }
            }
            else {
                app = line.split(';')
                applicationsMenu.add(JMenuItem(object : AbstractAction(app[0]) {
                    // Upon clicking the item, run specified command
                    override fun actionPerformed(e: ActionEvent?) {
                        Runtime.getRuntime().exec(app[1])
                    }
                }))
            }
        }

        // Close scanners
        prefFile.close()
        appMenuFile.close()
        // Java theme
        setDefaultLookAndFeelDecorated(true)
        Launcher(applicationsMenu, prefs).launcher()
    }
}

fun main(args: Array<String>) {
    Start()
}
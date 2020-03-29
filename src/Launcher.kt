/*
File: Launcher.kt
-----------------
This is the main launcher window. It houses the program menus and title text.
 */

import java.io.File
import java.util.*
import javax.swing.*
import kotlin.system.exitProcess

class Launcher(appMenu: JMenu, prefs: Array<Any>) : JFrame() {
    fun launcher() {
        this.isVisible = true
    }

    init {

        // Java theme
        setDefaultLookAndFeelDecorated(true)
        // Window title
        title = "MorningCoffee"
        // Stop user for resizing window
        isResizable = false
        // Do nothing when user attempts to close window
        defaultCloseOperation = DO_NOTHING_ON_CLOSE
        // Set location of window to specified starting position
        setBounds(prefs[0] as Int, prefs[1] as Int, 260, 105)

        // Top menu bar
        val menuBar = JMenuBar()
        jMenuBar = menuBar
        // Applications menu
        menuBar.add(appMenu)
        // System menu
        val systemMenu = JMenu("System")
        menuBar.add(systemMenu)

        // System menu items
        // Exit
        val mItemExit = JMenuItem("Exit MorningCoffee")
        // On click, open exit confirm dialog
        mItemExit.addActionListener{
            JDialog.setDefaultLookAndFeelDecorated(true)
            val response = JOptionPane.showConfirmDialog(null,
                "Do you want to exit MorningCoffee?", "Exit MorningCoffee", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE)
            if (response == JOptionPane.YES_OPTION)
                exitProcess(0)
        }
        systemMenu.add(mItemExit)
        // Shutdown
        val mItemShutdown = JMenuItem("Shut Down")
        // On click, open shutdown confirm dialog
        mItemShutdown.addActionListener{
            JDialog.setDefaultLookAndFeelDecorated(true)
            val response = JOptionPane.showConfirmDialog(null,
                "Do you want to shut off your computer?", "Shut Down", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE)
            if (response == JOptionPane.YES_OPTION) {
                val os = System.getProperty("os.name").toLowerCase()
                // Check for Windows
                if (os.indexOf("win") >= 0)
                    Runtime.getRuntime().exec("shutdown /s /t 00")
                // Check for macOS
                // not sure if this actually works, someone please test it
                else if (os.indexOf("mac") >= 0)
                    Runtime.getRuntime().exec("osascript -e 'tell app \"System Events\" to shut down'")
                // Check for *nix based OSes
                else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0
                    || os.indexOf("sunos") >= 0)
                    Runtime.getRuntime().exec("poweroff")
            }
        }
        systemMenu.add(mItemShutdown)
        // About
        val mItemAbout = JMenuItem("About MorningCoffee")
        // On click, open About window
        mItemAbout.addActionListener{ About().about() }
        systemMenu.add(mItemAbout)
    }
}
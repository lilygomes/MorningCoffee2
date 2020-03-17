/*
File: Launcher.kt
-----------------
This is the main launcher window. It houses the program menus and title text.
 */

import java.awt.event.ActionListener
import javax.swing.*

class Launcher: JFrame() {
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
        // Set window size
        setBounds(100, 100, 260, 105)

        // Top menu bar
        val menuBar = JMenuBar()
        jMenuBar = menuBar
        // Applications menu
        val applicationsMenu = JMenu("Applications")
        menuBar.add(applicationsMenu)
        // System menu
        val systemMenu = JMenu("System")
        menuBar.add(systemMenu)

        // System menu items
        // Exit
        val mItemExit = JMenuItem("Exit MorningCoffee")
        // On click, open exit confirm dialog
        mItemExit.addActionListener{ /* TODO confirmation dialog */ }
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
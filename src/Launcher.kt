import java.awt.event.ActionListener
import javax.swing.*

class Launcher: JFrame() {
    init {
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
        mItemExit.addActionListener(ActionListener { /* TODO confirmation dialog */ })
        systemMenu.add(mItemExit)
        // Shutdown
        val mItemShutdown = JMenuItem("Shut Down")
        // On click, open shutdown confirm dialog
        mItemShutdown.addActionListener(ActionListener { /* TODO confirmation dialog */ })
        systemMenu.add(mItemShutdown)
        // About
        val mItemAbout = JMenuItem("About MorningCoffee")
        // On click, open About window
        mItemAbout.addActionListener(ActionListener { /* TODO About window */ })
        systemMenu.add(mItemAbout)
    }
}

fun main() {
    val frame = Launcher()
    frame.isVisible = true
}
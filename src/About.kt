/*
File: About.kt
--------------
This is the About window that shows the credits and version number.
 */

import java.awt.Font
import java.io.File
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.border.EmptyBorder

const val VERSION_STRING = "Alpha 1"

class About: JFrame() {

    fun about() {
        this.isVisible = true
    }

    private val contentPane = JLabel()

    init {
        setBounds(100, 100, 365, 170)
        isResizable = false
        contentPane.border = EmptyBorder(5, 5, 5, 5)
        setContentPane(contentPane)
        contentPane.layout = null

        // Text
        val lblTitle = JLabel("MorningCoffee 2")
        lblTitle.setBounds(11, 13, 235, 53)
        lblTitle.font = Font(lblTitle.font.name, Font.PLAIN, 28)
        contentPane.add(lblTitle)

        val lblVersion = JLabel(VERSION_STRING)
        lblVersion.setBounds(12, 59, 94, 27)
        lblVersion.font = Font(lblVersion.font.name, Font.PLAIN, 20)
        contentPane.add(lblVersion)

        val lblDeveloper = JLabel("Designed by lilygomes on GitHub.")
        lblDeveloper.setBounds(12, 92, 260, 24)
        lblVersion.font = Font(lblVersion.font.name, Font.PLAIN, 16)
        contentPane.add(lblDeveloper)

        // Icon
        val icoJava = JLabel("")
        val img = ImageIcon(ImageIO.read(File("img/java-80x80.png")))
        icoJava.icon = img
        icoJava.setBounds(270, 36, 80, 80)
        contentPane.add(icoJava)
    }
}

import java.io.File
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.border.EmptyBorder

class About: JFrame() {

    fun about() {
        val frame = About()
        frame.isVisible = true
    }

    private val contentPane = JLabel()

    init {
        // TODO finalize size
        setBounds(100, 100, 366, 195)
        isResizable = false
        contentPane.border = EmptyBorder(5, 5, 5, 5)
        setContentPane(contentPane)
        contentPane.layout = null

        // Text
        val lblTitle = JLabel("MorningCoffee 2")
        lblTitle.setBounds(12, 13, 216, 53)
        contentPane.add(lblTitle)

        val lblVersion = JLabel("Alpha 1")
        lblVersion.setBounds(12, 59, 94, 27)
        contentPane.add(lblVersion)

        val lblDeveloper = JLabel("Designed by frankgomes on GitHub.")
        lblDeveloper.setBounds(12, 92, 247, 24)
        contentPane.add(lblDeveloper)

        // Icon
        val icoJava = JLabel("")
        val img = ImageIcon(ImageIO.read(File("img/java-80x80.png")))
        icoJava.icon = img
        icoJava.setBounds(265, 36, 80, 80)
        contentPane.add(icoJava)
    }
}
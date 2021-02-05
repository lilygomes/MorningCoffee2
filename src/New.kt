/*
File: New.kt
--------------
This is the New window that lets the user add a new program to MorningCoffee.
 */
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.Font
import java.io.File
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField
import javax.swing.border.EmptyBorder


class New: JFrame() {

    fun new() {
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
        val lblTitle = JLabel("Add a program:")
        lblTitle.setBounds(11, 13, 235, 53)
        lblTitle.font = Font(lblTitle.font.name, Font.PLAIN, 28)
        contentPane.add(lblTitle)

        val programName = JTextField("Program Name");
        programName.setBounds(12, 59, 124, 27)
        contentPane.add(programName)

        val command = JTextField("Command to run");
        command.setBounds(146, 59, 124, 27)
        contentPane.add(command)
        
        class ButtonClickListener : ActionListener {
           override fun actionPerformed(e: ActionEvent) {
                if (e.actionCommand == "Submit") {
                    File("mc2/applications").writeText(programName.getText() + ";" + command.getText())
                }
            }
        }

        val submit = JButton("Add Program").apply {
            actionCommand = "Submit"
            addActionListener(ButtonClickListener())
        }
        submit.setBounds(12, 99, 124, 27)
        contentPane.add(submit)
    }
}

package Components;

import Entities.Book;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Utils.Formatter.capitalize;

public class Form extends JPanel implements ActionListener {
    FormField bookTitleField;
    FormField authorNameField;
    SubmitBtn submitBtn;
    GridBagConstraints gbc;

    Border borderBottom = BorderFactory.createMatteBorder(0,0, 2,0, Color.black);

    DisplayBooks displayBooks;

    public Form(DisplayBooks displayBooks) {
        this.displayBooks = displayBooks;

        setPreferredSize(new Dimension(0, 100));
        setBorder(borderBottom);
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(0,0,0,16);

        bookTitleField = new FormField("Book title");
        authorNameField = new FormField("Author name");
        submitBtn = new SubmitBtn("Submit");

        submitBtn.addActionListener(this);

        add(bookTitleField, gbc);
        add(authorNameField, gbc);

        gbc.insets = new Insets(0,0,0,0);
        add(submitBtn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitBtn) {
            JTextField bookTitleInput = bookTitleField.input;
            JTextField authorNameInput = authorNameField.input;

            String bookTitle = bookTitleInput.getText();
            String authorName = authorNameInput.getText();

            Book.insertBook(bookTitle, authorName);
            displayBooks.refreshDisplayBooks();
        }
    }
}

class FormField extends JPanel {
    JLabel label;
    Font labelFont = new Font("Arial", Font.BOLD, 16);
    Color labelFontColor = new Color(0,0,0);

    JTextField input;
    Font inputFont = new Font("Arial", Font.PLAIN, 16);
    Color inputFontColor = new Color(0,0,0);
    Border inputLineBorder = BorderFactory.createLineBorder(Color.black, 2, true);
    Border inputPadding = BorderFactory.createEmptyBorder(2,4,2,2);
    Border inputBorder = BorderFactory.createCompoundBorder(inputLineBorder, inputPadding);

    GridBagConstraints gbc;

    FormField(String labelTxt) {
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(0, 50));
        gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0,0,0,8);

        label = new JLabel();
        label.setText(capitalize(labelTxt) + ":");
        label.setFont(labelFont);
        label.setForeground(labelFontColor);

        add(label, gbc);

        input = new JTextField();
        input.setPreferredSize(new Dimension(150, 30));
        input.setFont(inputFont);
        input.setForeground(inputFontColor);
        input.setBorder(inputBorder);

        gbc.insets = new Insets(0,0,0,0);
        add(input, gbc);
    }
}

class SubmitBtn extends JButton {
    Color accent = new Color(0, 63, 255);

    Color bg = accent;
    Color fontColor = new Color(255,255,255);
    Font font = new Font("Arial", Font.BOLD, 16);
    Border lineBorder = BorderFactory.createLineBorder(accent, 2, true);
    Border padding = BorderFactory.createEmptyBorder(2,5,2,5);
    Border border = BorderFactory.createCompoundBorder(lineBorder, padding);

    SubmitBtn(String txt) {
        super(txt);
        setPreferredSize(new Dimension(120,30));
        setBorder(border);
        setBackground(bg);

        setFont(font);
        setForeground(fontColor);
    }
}
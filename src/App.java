import Components.DisplayBooks;
import Components.Form;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    // ===== Attributes ===== //
    int height = 500;
    int width = 800;
    Color bg = new Color(255,255,255);
    GridBagConstraints gbc;

    // ===== Elements & Components ===== //
    Form addBook;
    DisplayBooks displayBooks;

    App() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width, height));
        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        // GBC Settings
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0;

        displayBooks = new DisplayBooks();
        addBook = new Form(displayBooks);

        gbc.gridy = 0;
        add(addBook, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        add(displayBooks, gbc);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

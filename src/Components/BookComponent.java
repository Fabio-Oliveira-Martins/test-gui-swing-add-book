package Components;

import Entities.Book;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class BookComponent extends JPanel {
    GridBagConstraints gbc;

    BookCover bookCoverEl;
    BookTitle bookTitleEl;
    AuthorName authorNameEl;

    public BookComponent(Book book) {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        bookCoverEl = new BookCover();
        bookTitleEl = new BookTitle(book.getTitle());
        authorNameEl = new AuthorName(book.getAuthorName());

        gbc.gridy = 0;
        add(bookCoverEl, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,0,0,0);
        add(bookTitleEl, gbc);

        gbc.gridy = 2;
        add(authorNameEl, gbc);
    }
}

class BookCover extends JPanel {
    Color[] colors = {
            new Color(219, 225, 241),
            new Color(238, 255, 214),
            new Color(225, 197, 233),
            new Color(80, 80, 80),
            new Color(224, 103, 103),
            new Color(103, 224, 178),
            new Color(161, 103, 224),
            new Color(241, 206, 49),
            new Color(133, 224, 103),
            new Color(252, 229, 149)
    };
    Color randomColor = colors[randomColorIndex()];
    Border lineBorder = BorderFactory.createLineBorder(randomColor, 2, true);

    BookCover() {
        setPreferredSize(new Dimension(0, 275));
        setBackground(randomColor);
        setBorder(lineBorder);
    }

    private int randomColorIndex() {
        return ThreadLocalRandom.current().nextInt(0, colors.length - 1);
    }
}

class BookTitle extends JLabel {
    Font font = new Font("Arial", Font.BOLD, 16);
    Color fontColor = new Color(110, 110, 110);

    BookTitle(String title) {
        setFont(font);
        setForeground(fontColor);
        setText(title);
    }
}

class AuthorName extends JLabel {
    Font font = new Font("Arial", Font.PLAIN, 16);
    Color fontColor = new Color(0,0,0);

    AuthorName(String authorName) {
        setFont(font);
        setForeground(fontColor);
        setText(authorName);
    }
}

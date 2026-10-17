package Components;

import Entities.Book;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static Entities.Book.getAllBooks;

public class DisplayBooks extends JPanel {
    int gap = 8;
    Border padding = BorderFactory.createEmptyBorder(8,8,8,8);
    GridBagConstraints gbc;

    JPanel booksContainer;
    BookComponent bookComponent;
    JScrollPane scrollbar;

    public DisplayBooks() {
        setPreferredSize(new Dimension(0, 0));
        setBorder(padding);
        setLayout(new BorderLayout());

        booksContainer = new JPanel();
        booksContainer.setLayout(new GridBagLayout());

        refreshDisplayBooks();

        scrollbar = new JScrollPane(booksContainer);
        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollbar, BorderLayout.CENTER);
    }

    public void refreshDisplayBooks() {
        booksContainer.removeAll();

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(gap,gap,gap,gap);

        ArrayList<Book> books = getAllBooks();

        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            bookComponent = new BookComponent(book);

            gbc.gridx = i % 4;
            gbc.gridy = i / 4;

            booksContainer.add(bookComponent, gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        booksContainer.add(Box.createGlue(), gbc);
        booksContainer.revalidate();
        booksContainer.repaint();
    }
}

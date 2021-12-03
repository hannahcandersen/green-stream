package View;

import java.awt.*;

import javax.swing.*;
import java.util.ArrayList;

public class SearchPage extends JFrame {
    private JTextField searchable;
    private JButton searchB;
    private Menubar menubar;
    private JPanel panel;

    public SearchPage() {
        super("GreenStream");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchable = new JTextField(20);
        searchB = new JButton("Søg");

        panel = new JPanel(new BorderLayout());
        panel.setSize(25, 10);
        searchable.setText("Søg");
        searchable.setSize(20, 5);
        searchB.setSize(5, 5);

        panel.add(searchable, BorderLayout.CENTER);
        panel.add(searchB, BorderLayout.EAST);

        Container contentPane = getContentPane();
        contentPane.setSize(30, 10);
        contentPane.add(panel);


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneDisplay; // Text area to display fortunes
    private final ArrayList<String> fortunes; // List of fortunes
    private int lastFortuneIndex = -1; // Keeps track of the last displayed fortune index

    public FortuneTellerFrame() {
        // Sets up the main frame properties
        setTitle("Fortune Teller"); // Window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.75), 400); // Sets frame to 3/4 of screen width
        setLocationRelativeTo(null); // Centers the window on screen
        setLayout(new BorderLayout()); // Uses BorderLayout for component placement

        // TOP PANEL
        JPanel topPanel = new JPanel(new BorderLayout()); // Panel to hold title and image
        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER); // Title label centered
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48)); // Sets large font for title

        // Loads and displays an image icon
        ImageIcon fortuneIcon = new ImageIcon("fortune_icon.png"); // Loads image from project folder
        JLabel imageLabel = new JLabel(fortuneIcon, JLabel.CENTER); // Centers the image label

        topPanel.add(titleLabel, BorderLayout.NORTH); // Adds title to top
        topPanel.add(imageLabel, BorderLayout.CENTER); // Adds image below the title
        add(topPanel, BorderLayout.NORTH); // Adds top panel to frame

        // MIDDLE PANEL
        fortuneDisplay = new JTextArea(10, 40); // Text area with 10 rows and 40 columns
        fortuneDisplay.setEditable(false); // Disables editing
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Sets font for text area
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay); // Adds text area to a scroll pane
        add(scrollPane, BorderLayout.CENTER); // Adds scroll pane to center

        // BOTTOM PANEL
        JPanel bottomPanel = new JPanel(); // Panel for buttons
        JButton fortuneButton = new JButton("Read My Fortune!"); // Button to get a fortune
        JButton quitButton = new JButton("Quit"); // Button to quit the application

        // Sets font for buttons
        fortuneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        // Adds action listeners to buttons
        fortuneButton.addActionListener(this::generateFortune); // On click, generates fortune
        quitButton.addActionListener(e -> System.exit(0)); // Lambda expression to quit the program

        // Adds buttons to bottom panel
        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH); // Adds bottom panel to frame

        // Initializes the fortune list
        fortunes = new ArrayList<>();
        populateFortunes(); // Populates the list with fortunes
    }

    // Methods to populate the fortune list with 12 humorous fortunes
    private void populateFortunes() {
        fortunes.add("You will have a lucky day today!");
        fortunes.add("A great surprise is coming your way.");
        fortunes.add("Your kindness will be repaid in unexpected ways.");
        fortunes.add("An exciting adventure awaits you.");
        fortunes.add("A big opportunity is just around the corner.");
        fortunes.add("Someone from your past will reappear soon.");
        fortunes.add("Your hard work will pay off soon.");
        fortunes.add("You will soon receive good news.");
        fortunes.add("Happiness comes to those who seek it.");
        fortunes.add("A small risk will lead to a big reward.");
        fortunes.add("An old friend will bring you joy.");
        fortunes.add("You will overcome a challenge with ease.");
    }

    // Methods to generate and display a random fortune
    private void generateFortune(ActionEvent e) {
        Random rand = new Random(); // Creates Random object
        int index;
        do {
            index = rand.nextInt(fortunes.size()); // Generates a random index
        } while (index == lastFortuneIndex); // Ensures it's not the same as the last fortune

        lastFortuneIndex = index; // Updates last fortune index
        fortuneDisplay.append(fortunes.get(index) + "\n"); // Displays the fortune in the text area
    }
}

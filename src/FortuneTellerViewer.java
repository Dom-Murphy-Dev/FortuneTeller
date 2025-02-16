import javax.swing.*;

// Main class to launch the Fortune Teller application.
public class FortuneTellerViewer {
    public static void main(String[] args) {
        // Schedules the application to run on the Event Dispatch Thread for thread safety.
        SwingUtilities.invokeLater(() -> {
           FortuneTellerFrame frame = new FortuneTellerFrame(); // Creates the main GUI frame.
           frame.setVisible(true); // Displays the GUI frame.
        });
    }
}
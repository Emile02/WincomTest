import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String[] myResearchKeywords; // array of given keywords
    private static JTextField inputField; // inputField for my graphic bonus
    private static JLabel[] resultLabels; // array of results used in my graphic bonus

    // this function is the first assignment asked for the ted
    public static void consoleTest() { // create a void function because I dont need any return
        Scanner scanner = new Scanner(System.in); // I use Scanner to catch user input
        while (true) {
            System.out.println("Search what you want below:"); // asking the user to write something
            String researchGoogle = scanner.nextLine().toLowerCase(); // convert the string to not be case sensitive

            int count = 0; // create a counter to show the amount of result I want
            for (String keyword : myResearchKeywords) { // for loop to iterate through "myResearchKeywords" array
                if (count >= 4) { // when I display 4 results, I stop
                    break;
                }
                if (keyword.toLowerCase().startsWith(researchGoogle)) { // I use toLowerCase again, and the function startsWith(), to find a match (better to use this that a basic for loop)
                    System.out.println(keyword); // print the result
                    count++; // increment
                }
            }

            if (count == 0) { // if I have no result at all I print a sentence
                System.out.println("No results to show");
            } else if (count < 4) {
                System.out.println("No more results to show"); // if I have at least 1 result but under 4, I print another sentence
            }
        }
    }

    private static void createUI() { // create a bonus function to go deeper in some java concept
        JFrame frame = new JFrame("Wincom Test"); // add a title to the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make closable the window
        frame.setLayout(new FlowLayout()); // add layout system

        inputField = new JTextField(20); // initialize the variable

        frame.add(inputField); // add the field to my window

        resultLabels = new JLabel[4]; // initialize array
        for (int i = 0; i < 4; i++) { // easy forloop
            resultLabels[i] = new JLabel(); // initialize resultLabels to a JLabel to be able to use it in the window
            frame.add(resultLabels[i]); // add it to the frame
        }

        inputField.addKeyListener(new KeyListener() { // add a keylistener to my input field
            @Override
            public void keyTyped(KeyEvent e) { // only function I need to override
                updateResults("app");
            }

            // but I had to declare those anyway
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.setPreferredSize(new Dimension(250, 400)); // I set a size to my window
        frame.pack(); // useful function
        frame.setVisible(true); // useful function
    }

    static void updateResults(String app) { // function who update my result depending on the input
        String researchGoogle = inputField.getText().toLowerCase(); // again put the text in lowercase

        int count = 0; // initialize a counter
        for (int i = 0; i < 4; i++) { // first display anything
            resultLabels[i].setText("");
        }

        for (String keyword : myResearchKeywords) { // forloop in "myResearchKeywords"
            if (count >= 4) {
                break;
            }

            int index = keyword.toLowerCase().indexOf(researchGoogle); // initialize index
            if (index != -1 && keyword.toLowerCase().startsWith(researchGoogle)) { // if I find a index
                String match = keyword.substring(index, index + researchGoogle.length()); // I have my string who is equal to the input
                String rest = keyword.substring(index + researchGoogle.length()); // here is the rest of the word

                JLabel label = new JLabel("<html>" + match + "<b>" + rest + "</b></html>"); // I create a JLabel with html to be able to display as I want the strings
                resultLabels[count].setText(label.getText()); // I set the text
                resultLabels[count].setFont(new Font("Arial", Font.PLAIN, 12)); // I set a font
                count++; // increment
            }
        }

        if (count == 0) {
            JLabel noResultLabel = new JLabel("<html>" + "<u><i>" + "No Result To Show !!" + "</i></html>"); // if I have no result at all I print a sentence
            resultLabels[count].setText(noResultLabel.getText());
        } else if (count > 0 && count < 4) {
            JLabel noMoreResultsLabel = new JLabel("<html>" + "<u><i>" + "No More Results To Show !" + "</i></html>"); // if I have at least 1 result but under 4, I print another sentence
            resultLabels[count].setText(noMoreResultsLabel.getText());
        }
    }

    public static void main(String[] args) {
        // I initialize the array of keywords
        myResearchKeywords = new String[]{"Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv", "Priceline", "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"};
        // Sort it
        Arrays.sort(myResearchKeywords);

        // start my graphic asynchronous way the method createUI thanks to invoke later, good swing practice
        SwingUtilities.invokeLater(() -> createUI());
        // start my console function
        consoleTest();
    }
}
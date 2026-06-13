import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Music Player;

        String PATH = "C:\\Users\\offic\\Downloads\\kgf_rocky.wav";
        File file = new File(PATH);
        try (Scanner scanner = new Scanner(System.in);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            // clip object

            Clip clip = AudioSystem.getClip(); // gives us audio controls
            clip.open(audioStream);

            // make user-friendly.
            boolean run = true;

            while (run) {
                System.out.println("1. play -> press (p):  ");
                System.out.println("2. stop -> press (s):  ");
                System.out.println("3. reset -> press (r):  ");
                System.out.println("4. exit -> press (e):  ");
                System.out.print("Enter your choice: ");
                char choice = scanner.next().charAt(0);

                switch(choice) {
                    case 'p' -> clip.start();
                    case 's' -> clip.stop();
                    case 'r' -> clip.setMicrosecondPosition(0);
                    case 'e' -> {
                        clip.close();
                        run = false;
                    }
                    default -> System.out.println("Select a valid option!");
                }
            }

//            Thread.sleep(2000);
        }

        catch (LineUnavailableException e) {
            System.out.println("Audio is not available in file!");
        }
        catch( UnsupportedAudioFileException e) {
            System.out.println("Audio is not supported");
        }
        catch(IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}
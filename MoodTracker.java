import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MoodTracker {
    public static String mood;
    public static LocalDate today;
    public static LocalTime time;
    public static String currentMood;

    static void viewLog(ArrayList<String> log)
    {
        for (int i = 0; i < log.size(); i++)
        {
            System.out.println(log.get(i));
        }
    }
    // get the users input and
    static void getLog(){
        Scanner input = new Scanner(System.in);

        System.out.println("What is your mood today?");
        mood = input.nextLine();

        today = LocalDate.now();
        time = LocalTime.now();
        
        currentMood = "Your mood on " + today.toString() + " by " + time.toString() + " was " + mood;
    //adds mood, date and time to a 2d list
        if (!(mood.equals("")))
        {
            System.out.println(currentMood);
            //log.add(new ArrayList<String>(Arrays.asList(mood, today.toString(), time.toString())));
        }
        else
        {
            System.out.println("You haven't put in a mood");
        }
        input.close();
    }
   // stores the users input in a list

    public static void main(String[] args) {
        ArrayList<String> log = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        boolean exit = true;
        while(exit == true){
            System.out.println("Mood Tracker Menu");
            System.out.println("1. Log a Mood");
            System.out.println("2. View Mood Log");
            System.out.println("3. Exit");

            System.out.println("Select option 1, 2 or 3");
            String selection = input.nextLine();
            if (selection.equals("1")){
                getLog();
                if(!(mood.equals("")))
                {
                    log.add(0, currentMood);
                }
            }
            else if(selection.equals("2"))
            {
                viewLog(log);
            }
            else if(selection.equals("3")){
                log.clear();
                System.out.println("mood log has been cleared");
                exit = false;
            }
            else
            {
                System.out.println("you don't select an option");
            }
        }
        input.close();
    }
}

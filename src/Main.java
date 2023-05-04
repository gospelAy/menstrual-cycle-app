import metralPackage.User;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static Scanner keyboardInputCollector = new Scanner(System.in);
    private static User user = new User();
    public static void main(String[] args){
        gotoMainMenu();
    }
    private static void gotoMainMenu(){
        String mainMenu = """
                ====================
                Welcome to period tracker
                1 -> Register
                2 -> Login
                3 -> FindUser
                4 -> Check your period
                5 -> Delete
                6 -> view
                7 -> Edit
                8 -> Exit
               """;
        String userInput = input(mainMenu);
        switch (userInput.charAt(0)){
            case '1' -> register();
            case '2' -> login();
            case '3' -> findUser();
            case '4' -> checkYourPeriod();
            case '5' -> delete();
            case '6' -> view();
            case '7' -> edit();
            case '8' -> exit();
            default -> gotoMainMenu();
        }
    }
    private static void register(){
        String firstName = input("Enter your first name");
        String lastName  = input("Enter your last name");
        String age = input("Enter your age");
        user.RegisterUser(firstName, lastName, Integer.parseInt(age));
        display("you have successfully registered ");

        gotoMainMenu();
    }
    private static void exit(){
        display("Thank you for using our application ");
        System.exit(1);
    }

    private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
    }
    private static void display(String prompt){
        JOptionPane.showInputDialog(null, prompt);
    }
    public static void view() {
        int findUser = Integer.parseInt(input("Enter your id to view"));
        display(user.findUserById(findUser));
        gotoMainMenu();
    }

    private static void checkYourPeriod() {
        String lastDayString = input("Enter the last day of your menstrual cycle (YYYY-MM-DD): ");
        int month = Integer.parseInt(input("Enter the number of months you want to calculate your next cycle for: "));
        display(" Your next menstrual cycles will be on the following dates " + user.calculateMenstrualCycle(lastDayString, month));
        gotoMainMenu();
    }

    private static void findUser() {
        String firstName = input("Enter your firstName to check ");
        String lastName = input("Enter your second name to check ");
        int age = Integer.parseInt(input("Enter your age"));
        display(user.findUserByName(firstName, lastName, age));
        gotoMainMenu();
    }

    public static void delete(){
        int deleteUser = Integer.parseInt(input("Enter your id to delete"));
        user.delete(deleteUser);
        display("deleted successfully");
        gotoMainMenu();
    }
    public static  void edit(){
    }
    public static void login(){
    }
}
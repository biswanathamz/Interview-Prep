import controller.ManagePassword;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean varExit = true;
        boolean defaultFlag = false;
        System.out.println("Welcome to Password Manager!");
        ManagePassword managePasswordObj = new ManagePassword();
        while (varExit){
            int mainMenuInput = printMainMenu(defaultFlag);
            defaultFlag = false;
            switch (mainMenuInput){
                case 1:
                    managePasswordObj.takeInputForNewPassword();
                    break;
                case 2:
                    managePasswordObj.viewAPassword();
                    break;
                case 3:
                    managePasswordObj.allWebsiteList();
                    break;
                case 4:
                    managePasswordObj.updatePassword();
                    break;
                case 6:
                    varExit = false;
                    break;
                default:
                    defaultFlag = true;
            }
        }
    }
    public static int printMainMenu(boolean defaultFlag){
        if (defaultFlag){
            System.out.println("Please choose correct Option!");
        }
        System.out.println("Please Enter 1 to Store a New Password");
        System.out.println("Please Enter 2 to View a Password");
        System.out.println("Please Enter 3 to list existing websites");
        System.out.println("Please Enter 4 to update a Password");
        System.out.println("Please Enter 5 to Delete a Password");
        System.out.println("Please Enter 6 to close");
        Scanner scannerObj = new Scanner(System.in);
        int mainMenuInput = 0;
        try{
            mainMenuInput =  Integer.parseInt(scannerObj.nextLine());
        }catch (NumberFormatException e){
            printMainMenu(true);
        }
        return mainMenuInput;
    }
}
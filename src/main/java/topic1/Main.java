package topic1;

public class Main {


    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Hello user! what is your firstname, lastname, and age");
            return;
        }
        else if (args.length != 3){
            System.out.println("Incorrect number of arguments provided\nThe correct format is firstname, lastname, and age");
            return;
        }

        String firstName = args[0];
        String lastName = args[1];
        int age;
        try {
            age = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e){
            System.out.println("Please provide a number as input for age");
            return;
        }

        System.out.println("Hello my name is " + firstName + " " + lastName + " and my age is " + age);

    }
}



package main;

public class Main {

    /*public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        boolean is_created = false;
        boolean is_login = false;

        while(true)
        {
            String ch;
            System.out.println("1. Create Account");
            System.out.println("2. Login");

            ch = input.nextLine();

            if(ch.equals("1"))
            {
                Account acc = new Account();
                User user = new User();

                System.out.print("First Name: ");
                user.firstName = input.nextLine();
                System.out.print("Last Name: ");
                user.lastName = input.nextLine();
                System.out.print("UserID: ");
                user.userID = input.nextLine();
                System.out.print("Password: ");
                user.password = input.nextLine();

                is_created = acc.createAccount(user);

            }

            else if(ch.equals("2"))
            {
                String userID;
                String password;

                System.out.print("UserID: ");
                userID = input.nextLine();
                System.out.print("Password: ");
                password = input.nextLine();

                Account acc = new Account();

                is_login = acc.login(userID, password);
            }

            if(!is_created && ch.equals("1"))
                System.out.println("Can't create your account! Try again.");
            else if(is_created && ch.equals("1"))
                break;

            if(!is_login && ch.equals("2"))
                System.out.println("Wrong userID or Password! Try again.");
            else if(is_login && ch.equals("2"))
                break;

        }

        //Generate next screen...

        System.out.println("1. Add Question.");
        System.out.println("2. Quiz.");

        String ch = input.nextLine();

        if(ch.equals("1"))
        {
            int numOfQuestion;
            String subject;
            System.out.print("Enter subject: ");
            subject = input.nextLine();
            System.out.print("Enter number of question: ");
            numOfQuestion = Integer.valueOf(input.nextLine());

            ArrayList<Question> question = new ArrayList<Question>();

            for(int i=0; i<numOfQuestion; i++)
            {
                Question q = new Question();

                System.out.print("Question: ");
                q.question = input.nextLine();
                System.out.print("Enter number of option: ");
                int numberOfOption = Integer.valueOf(input.nextLine());

                for(int j=0; j<numberOfOption; j++)
                    q.option.add(input.nextLine());

                System.out.print("Answer: ");
                q.answer = input.nextLine();
            }

            ObjectOutputStream objectout = new ObjectOutputStream(new FileOutputStream())




        }







    }*/

}

import java.util.Scanner;

public class Main {

    enum Option {
        PRODUCT, SUM, QUIT
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runGame();
    }

    static void runGame() {
        Option choice = getChoice();
        while (choice != Option.QUIT) {
            String password = getPassword();
            switch (choice) {
                case PRODUCT:
                    computeProduct(password, 0, 1);
                    break;
                case SUM:
                    computeSum(password, 0, 0.0);
                    break;
            }
            password = "";
            choice = getChoice();
        }
        System.out.println("Play again? (y/n):");
        String answer = scanner.next();
        if (answer.equals("y")) {
            runGame();
        } else {
            System.out.println("Goodbye!");
        }
    }

    static String getPassword() {
        System.out.println("Enter an 8-digit number-only password:");
        String password = scanner.next();
        while (password.length() != 8 || !password.matches("[0-9]+")) {
            System.out.println("Invalid. Password must be exactly 8 digits, numbers only:");
            password = scanner.next();
        }
        return password;
    }

    static void printMenu() {
        System.out.println("\nMenu:");
        for (Option opt : Option.values()) {
            System.out.println((opt.ordinal() + 1) + ": " + opt);
        }
    }

    static Option getChoice() {
        printMenu();
        System.out.println("Enter a number (1-" + Option.values().length + "):");
        int input = scanner.nextInt();
        Option choice = null;
        while (choice == null) {
            if (input >= 1 && input <= Option.values().length) {
                choice = Option.values()[input - 1];
            } else {
                System.out.println("Invalid. Enter a number (1-" + Option.values().length + "):");
                input = scanner.nextInt();
            }
        }
        return choice;
    }

    static void computeProduct(String password, int index, long product) {
        if (index < password.length()) {
            int digit = Character.getNumericValue(password.charAt(index));
            long updatedProduct = product;
            if (index == 0) {
                System.out.print(digit);
                updatedProduct = digit;
            } else {
                int prev = Character.getNumericValue(password.charAt(index - 1));
                System.out.print(" * (" + prev + "+" + digit + ")");
                updatedProduct = product * (prev + digit);
            }
            if (index == password.length() - 1) {
                System.out.println("=" + updatedProduct);
            }
            computeProduct(password, index + 1, updatedProduct);
        }
    }

    static void computeSum(String password, int index, double sum) {
        if (index < password.length()) {
            int digit = Character.getNumericValue(password.charAt(index));
            double updatedSum = sum + (digit == 0 ? 0 : 1.0 / (digit * digit));
            if (index == 0) {
                System.out.print("1/(" + digit + "*" + digit + ")");
            } else if (index == password.length() - 1) {
                System.out.print(digit == 1 ? "+1" : "+1/(" + digit + "*" + digit + ")");
                System.out.println("=" + updatedSum);
            } else {
                System.out.print("+1/(" + digit + "*" + digit + ")");
            }
            computeSum(password, index + 1, updatedSum);
        }
    }
}

/*OUTPUT
/Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=57795 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/aidentsang/IdeaProjects/CS213_L2_AT/out/production/CS213_L2_AT Main

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
1
Enter an 8-digit number-only password:
13578545
1 * (1+3) * (3+5) * (5+7) * (7+8) * (8+5) * (5+4) * (4+5)=6065280

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
1
Enter an 8-digit number-only password:
12345678910
Invalid. Password must be exactly 8 digits, numbers only:
90764324
9 * (9+0) * (0+7) * (7+6) * (6+4) * (4+3) * (3+2) * (2+4)=15479100

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
1
Enter an 8-digit number-only password:
123a4567
Invalid. Password must be exactly 8 digits, numbers only:
12345678
1 * (1+2) * (2+3) * (3+4) * (4+5) * (5+6) * (6+7) * (7+8)=2027025

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
2
Enter an 8-digit number-only password:
13246456
1/(1*1)+1/(3*3)+1/(2*2)+1/(4*4)+1/(6*6)+1/(4*4)+1/(5*5)+1/(6*6)=1.5816666666666666

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
2
Enter an 8-digit number-only password:
1432435645697
Invalid. Password must be exactly 8 digits, numbers only:
19384567
1/(1*1)+1/(9*9)+1/(3*3)+1/(8*8)+1/(4*4)+1/(5*5)+1/(6*6)+1/(7*7)=1.2897677311665408

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
2
Enter an 8-digit number-only password:
134m34234
Invalid. Password must be exactly 8 digits, numbers only:
33233333
1/(3*3)+1/(3*3)+1/(2*2)+1/(3*3)+1/(3*3)+1/(3*3)+1/(3*3)+1/(3*3)=1.027777777777778

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
3
Play again? (y/n):
y

Menu:
1: PRODUCT
2: SUM
3: QUIT
Enter a number (1-3):
3
Play again? (y/n):
n
Goodbye!

Process finished with exit code 0
 */
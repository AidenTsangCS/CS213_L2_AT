// Aiden Tsang
// Lab #2

import java.util.Scanner;

public class Main {

    enum Option {
        PRODUCT, SUM, QUIT
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Option choice = getChoice();
        while (choice != Option.QUIT) {
            switch (choice) {
                case PRODUCT:
                    int nProduct = getNumberOfTerms();
                    computeProduct(1, nProduct, 1);
                    break;
                case SUM:
                    int nSum = getNumberOfTerms();
                    computeSum(nSum, nSum, 0.0);
                    break;
                default:
                    break;
            }
            choice = getChoice();
        }
        System.out.println("Goodbye!");
    }

    static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)");
        System.out.println("2: Sum series      1/(n*n) + ... + 1/(2*2) + 1");
        System.out.println("3: Quit");
    }

    static int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // discard the invalid token
            System.out.println("Invalid entry. Please enter a whole number:");
        }
        return scanner.nextInt();
    }

    static Option getChoice() {
        printMenu();
        System.out.println("Enter a single digit (1-3):");
        int input = readInt();
        while (input < 1 || input > Option.values().length) {
            System.out.println("Invalid entry. Enter a single digit (1-3):");
            input = readInt();
        }
        return Option.values()[input - 1];
    }

    static int getNumberOfTerms() {
        System.out.println("Enter the number of terms (a whole number greater than 0):");
        int n = readInt();
        while (n < 1) {
            System.out.println("Invalid entry. Enter a whole number greater than 0:");
            n = readInt();
        }
        return n;
    }

  
    static void computeProduct(int i, int n, long product) {
        if (i == 1) {
            System.out.print("1");
            computeProduct(i + 1, n, 1);
        } else if (i <= n) {
            long term = (long) (i - 1) + i;
            System.out.print(" * (" + (i - 1) + "+" + i + ")");
            long updated = product * term;
            if (i == n) {
                System.out.println("=" + updated);
            } else {
                computeProduct(i + 1, n, updated);
            }
        } else {
            // n == 1 case: only the leading "1" was printed
            System.out.println("=" + product);
        }
    }


    static void computeSum(int i, int n, double sum) {
        double updated = sum + 1.0 / ((double) i * i);
        if (i == n) {
            if (i == 1) {
                System.out.print("1");
            } else {
                System.out.print("1/(" + i + "*" + i + ")");
            }
        } else if (i == 1) {
            System.out.print("+1");
        } else {
            System.out.print("+1/(" + i + "*" + i + ")");
        }

        if (i == 1) {
            System.out.println("=" + updated);
        } else {
            computeSum(i - 1, n, updated);
        }
    }
}
/* output
 /Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:60551,suspend=y,server=n -javaagent:/Users/aidentsang/Library/Caches/JetBrains/IntelliJIdea2026.1/captureAgent/debugger-agent.jar=file:///var/folders/7h/zb8m39j50bv8h4rvtp0xh3jw0000gn/T/capture16129346501150614777.props -agentpath:/private/var/folders/7h/zb8m39j50bv8h4rvtp0xh3jw0000gn/T/idea_libasyncProfiler_dylib_temp_folder/libasyncProfiler.dylib=version,jfr,event=wall,interval=10ms,cstack=no,file=/Users/aidentsang/IdeaSnapshots/Main_2026_07_07_192356.jfr,log=/private/var/folders/7h/zb8m39j50bv8h4rvtp0xh3jw0000gn/T/Main_2026_07_07_192356.jfr.log.txt,logLevel=DEBUG -Dkotlinx.coroutines.debug.enable.creation.stack.trace=false -Ddebugger.agent.enable.coroutines=true -Dkotlinx.coroutines.debug.enable.flows.stack.trace=true -Dkotlinx.coroutines.debug.enable.mutable.state.flows.stack.trace=true -Ddebugger.async.stack.trace.for.all.threads=true -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/aidentsang/IdeaProjects/CS213_L2_AT/out/production/CS213_L2_AT:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar Main
Connected to the target VM, address: '127.0.0.1:60551', transport: 'socket'

Menu:
1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)
2: Sum series      1/(n*n) + ... + 1/(2*2) + 1
3: Quit
Enter a single digit (1-3):
1
Enter the number of terms (a whole number greater than 0):
10
1 * (1+2) * (2+3) * (3+4) * (4+5) * (5+6) * (6+7) * (7+8) * (8+9) * (9+10)=654729075

Menu:
1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)
2: Sum series      1/(n*n) + ... + 1/(2*2) + 1
3: Quit
Enter a single digit (1-3):
2
Enter the number of terms (a whole number greater than 0):
10
1/(10*10)+1/(9*9)+1/(8*8)+1/(7*7)+1/(6*6)+1/(5*5)+1/(4*4)+1/(3*3)+1/(2*2)+1=1.5497677311665408

Menu:
1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)
2: Sum series      1/(n*n) + ... + 1/(2*2) + 1
3: Quit
Enter a single digit (1-3):
3
Goodbye!
Disconnected from the target VM, address: '127.0.0.1:60551', transport: 'socket'

Process finished with exit code 0

/Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=60709 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/aidentsang/IdeaProjects/CS213_L2_AT/out/production/CS213_L2_AT Main

Menu:
1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)
2: Sum series      1/(n*n) + ... + 1/(2*2) + 1
3: Quit
Enter a single digit (1-3):
a
Invalid entry. Please enter a whole number:
1
Enter the number of terms (a whole number greater than 0):
a
Invalid entry. Please enter a whole number:
2
1 * (1+2)=3

Menu:
1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)
2: Sum series      1/(n*n) + ... + 1/(2*2) + 1
3: Quit
Enter a single digit (1-3):
2
Enter the number of terms (a whole number greater than 0):
a
Invalid entry. Please enter a whole number:
10
1/(10*10)+1/(9*9)+1/(8*8)+1/(7*7)+1/(6*6)+1/(5*5)+1/(4*4)+1/(3*3)+1/(2*2)+1=1.5497677311665408

Menu:
1: Product series  1 * (1+2) * (2+3) * ... * ((n-1)+n)
2: Sum series      1/(n*n) + ... + 1/(2*2) + 1
3: Quit
Enter a single digit (1-3):
3
Goodbye!

Process finished with exit code 0

*/


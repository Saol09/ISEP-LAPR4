
import java.util.Scanner;

public class ClientDigitalTwinUI {
    static ClientDigitalTwinController controller = new ClientDigitalTwinController();



    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String agvID, choice3;
        int choice1, choice2;



        System.out.println("Insert AGV ID: ");
        agvID = scanner.nextLine();
        System.out.println("1 ->Change Task");
        System.out.println("2 ->Change Status");
        choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.println("Choose the task: ");
                scanner.nextLine();
                choice3 = scanner.nextLine();

                controller.task(agvID, 2, choice3);
                break;
            case 2:
                System.out.println("1 -> Change AGV status to Free");
                System.out.println("2 -> Change AGV status to Charging");
                System.out.println("3 -> Change AGV status to Occupied");
                choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        controller.status(agvID, 3);
                        break;
                    case 2:
                        controller.status(agvID, 4);
                        break;
                    case 3:
                        controller.status(agvID, 5);
                        break;
                }
        }
    }
}






public class ClientDigitalTwinController {



   public void task(String agvID, int i, String choice3) {
       DigitalTwinClient.changeAGVTask(agvID, i, choice3);
    }


    public void status(String agvID, int i) {
        DigitalTwinClient.changeAGVStatus(agvID, i);
    }



    public void server() throws Exception {
       DigitalTwinServer.mainCaller();

    }


}

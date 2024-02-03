import java.util.*;

public class OnlineReservationSystem {
    private static final int min = 1000 ; 
    private static final int max = 9999;

    public static class user{
        private String username;
        private String password;

      Scanner scan = new Scanner(System.in);

      public user(){

      }

      public String getUsername(){
      System.out.println("Enter Username::");
      username = scan.nextLine();
      return username;
      }

      public String getPassword(){
        System.out.println("Enter Password::");
        password = scan.nextLine();
        return password;
      }
    }
    
    public static class PnrRecord{
        private int pnrNumber;
        private String passengerName;
        private String trainNumber ;
        private String classType;
        private String journeyData;
        private String from ; 
        private String to;

        Scanner scan = new Scanner(System.in);

        public int getpnrNumber(){
            Random ran= new Random();
            pnrNumber = ran.nextInt(max)+min;
            return pnrNumber;
        }

        public String getPassengerName(){
           System.out.println("Enter the Passenger Name::");
            passengerName =scan.nextLine();
            return passengerName;
        }

        public String gettrainNumber(){
            System.out.println("Enter the Train Number::");
             trainNumber =scan.nextLine();
             return trainNumber;
         }

         public String getclassType(){
            System.out.println("Enter the Class Type::");
             classType =scan.nextLine();
             return classType;
         }

         public String getjourneyDate(){
            System.out.println("Enter the Journey date as 'DD-MM=YYYY' Format::");
             journeyData =scan.nextLine();
             return journeyData;
         }

         public String getfrom(){
            System.out.println("Enter the Starting Place ::");
             from =scan.nextLine();
             return from;
         }

         public String getto(){
            System.out.println("Enter the Destination Place ::");
             to =scan.nextLine();
             return to;
         }

    }

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        user u1 =new user();
        String username =u1.getUsername();
        String password = u1.getPassword();

        Map<Integer, PnrRecord> pnrMap =new HashMap<>();

        while (true) {
            System.out.println("Enter the Choice::");
            System.out.println("1. Insert Record.");
            System.out.println("2. Delete Record." );
            System.out.println("3. Show All Records.");
            System.out.println("4. Cancel Ticket.");
            System.out.println("5. Exit.");
            int choice = scan.nextInt();

            if (choice == 1) {
                PnrRecord p1 = new PnrRecord();
                int pnr_number = p1.getpnrNumber();
                PnrRecord newRecord = new PnrRecord();
                newRecord.passengerName =p1.getPassengerName();
                newRecord.trainNumber = p1.gettrainNumber();
                newRecord.classType = p1.getclassType();
                newRecord.journeyData = p1.getjourneyDate();
                newRecord.from = p1.getfrom();
                newRecord.to = p1.getto();
                pnrMap.put(pnr_number, newRecord);
                System.out.println("Records added Succesfully..");
                
            }else if (choice == 2) {
                System.out.println("Enter the PNR  Number to delete the record::");
                int pnrNumber =scan.nextInt();
                if (pnrMap.containsKey(pnrNumber)) {
                    pnrMap.remove(pnrNumber);
                    System.out.println("Record delete Successfully.");   
                }else{
                    System.out.println("Record with givin PNR Not found.");
                }
                
            }else if (choice == 3) {
                System.out.println("All record printing..\n");
                for(Map.Entry<Integer, PnrRecord>entry : pnrMap.entrySet()){
                    int pnrNumber = entry.getKey();
                    PnrRecord record = entry.getValue();
                    System.out.println("PNR Number:"+pnrNumber);
                    System.out.println("Passenger Name:"+record.passengerName);
                    System.out.println("Train Number:"+record.trainNumber);
                    System.out.println("Class Type:"+record.classType);
                    System.out.println("Journey Date:"+record.journeyData);
                    System.out.println("From Location:"+record.from);
                    System.out.println("To Location:"+record.to);
                    System.out.println("-------------------------------");

                }
            }
            else if (choice == 4){
                System.out.println("Enter the PRN number to Cancel the Ticket ::");
                int pnrNumber = scan.nextInt();
                if (pnrMap.containsKey(pnrNumber)) {
                    pnrMap.remove(pnrNumber);
                    System.out.println("Ticket with PNR number "+ pnrNumber+" Canceled Successfully.");
                    
                }else{
                    System.out.println("Ticket with given PNR number not found.");
                }

            }else if (choice == 5 ) {
                System.out.println("Exiting the Program.");
                break;
            }else{
                System.out.println("Invalid Choice! Please Enter from 1 to 4.. ");
            }
            
        }
       scan.close();
    }

}
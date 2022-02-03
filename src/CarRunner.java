import java.util.ArrayList;
import java.util.Arrays;

public class CarRunner
{
  public static int passedTests = 0;
  public static int failedTests = 0;
    
  public static void main(String[] args)
  {
    UsedCarLot lot = new UsedCarLot();
    Car car1 = new Car("Mustang", 12500);
    Car car2 = new Car("Camry", 8400);
    Car car3 = new Car("Ram", 17200);
    Car car4 = new Car("Accent", 1980);
    Car car5 = new Car("Cruiser", 10500);
    
    System.out.println("------- TEST new addCar method -------");
    // TEST #1
    lot.addCar(car1);
    testCarLot(new Car[]{car1}, lot.getInventory(), 1);
    
    // TEST #2
    lot.addCar(0, car2);
    testCarLot(new Car[]{car2, car1}, lot.getInventory(), 2);
    
    // TEST #3
    lot.addCar(1, car3);
    testCarLot(new Car[]{car2, car3, car1}, lot.getInventory(), 3);

    // TEST #4
    lot.addCar(0, car4);
    testCarLot(new Car[]{car4, car2, car3, car1}, lot.getInventory(), 4);

    // TEST #5
    lot.addCar(2, car5);
    testCarLot(new Car[]{car4, car2, car5, car3, car1}, lot.getInventory(), 5);

    System.out.println("------- TEST new moveCar method -------");
    System.out.println(lot.getInventory());
    // TEST #6
    lot.moveCar(1, 3); // moves Camry at index 1 to index 3; Cruiser and Ram shift left
    testCarLot(new Car[]{car4, car5, car3, car2, car1}, lot.getInventory(), 6);

    // TEST #7
    lot.moveCar(4, 0); // moves Mustang at index 4 to index 0; all cars shift right
    testCarLot(new Car[]{car1, car4, car5, car3, car2}, lot.getInventory(), 7);
    
    System.out.println("------- TEST new sellCarShift method -------");
    // TESTS #8 & 9
    Car soldCar = lot.sellCarShift(2); // REMOVES Cruiser and stores in soldCar
    testCarLot(new Car[]{car1, car4, car3, car2}, lot.getInventory(), 8);
    testCarLot(new Car[]{car5}, new ArrayList<Car>(Arrays.asList(new Car[]{soldCar})), 9);
    
    System.out.println("------- TEST new sellCarNoShift method -------");
    // TESTS #10 & 11
    Car soldCar2 = lot.sellCarNoShift(1); // REPLACES Accent with null and stores in soldCar2
    testCarLot(new Car[]{car1, null, car3, car2}, lot.getInventory(), 10);
    testCarLot(new Car[]{car4}, new ArrayList<Car>(Arrays.asList(new Car[]{soldCar2})), 11);
    
    System.out.println("----------------------------------------------");
    System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of 11");
    System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of 11");
  }
  
  public static void testCarLot(Car[] expInv, ArrayList<Car> actInv, int testNo)
  {
    ArrayList<Car> tempList = new ArrayList<Car>(Arrays.asList(expInv));
    System.out.print("TEST #" + testNo + " -- ");
    if (tempList.equals(actInv))
    {
      System.out.println("PASS");
      passedTests++;
    }
    else
    {
      System.out.println("*****FAIL*****");
      failedTests++;
    }
    System.out.println(" Expected: " + tempList);
    System.out.println("   Actual: " + actInv);
  }
}
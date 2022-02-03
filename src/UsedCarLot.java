import java.lang.reflect.Array;
import java.util.ArrayList;

public class UsedCarLot {
  // the car lot's inventory
  private ArrayList<Car> inventory;

  // constructs a new UsedCarLot object
  // sets inventory to an empty ArrayList of Cars
  public UsedCarLot() {
    inventory = new ArrayList<Car>();
  }

  // getter method: returns the inventory
  public ArrayList<Car> getInventory() {
    return inventory;
  }

  // adds a Car to the end of the inventory list
  public void addCar(Car carToAdd) {
    inventory.add(carToAdd);
  }

  // swaps the Car at idx1 with the Car at idx2 in inventory;
  // however, if either idx1 or idx2 exceed the bounds of the inventory,
  // do nothing (rather than crashing!).
  //
  // this method MODIFIES the state of the object (its inventory)
  public void swap(int idx1, int idx2) {
    if ((idx1 < 0) || (idx1 >= inventory.size()) || (idx2 < 0) || (idx2 >= inventory.size())) {
      return;
    }

    Car car = inventory.set(idx1, inventory.get(idx2));
    inventory.set(idx2, car);
  }

  public void addCar(int indexToAdd, Car carToAdd) {
    inventory.add(indexToAdd,carToAdd);
  }

  public Car sellCarShift(int indexOfCarToSell) {

    Car car = inventory.get(indexOfCarToSell);
    inventory.remove(indexOfCarToSell);
    return car;
  }

  public Car sellCarNoShift(int indexOfCarToSell)
  {
    Car car = inventory.get(indexOfCarToSell);
    inventory.set(indexOfCarToSell, null);
    return car;
  }

  public void moveCar(int indexOfCarToMove, int destinationIndex) {
    ArrayList<Car> tempList = new ArrayList<>();
    if(indexOfCarToMove<destinationIndex)
    {
      for(int i = indexOfCarToMove;i <= destinationIndex; i++)
      {
        tempList.add(inventory.get(i));
      }
      inventory.set(destinationIndex,tempList.get(0));
      for(int i = 1; i<tempList.size();i++)
      {
        inventory.set(indexOfCarToMove-1+i,tempList.get(i));
      }
    }
    if(indexOfCarToMove>destinationIndex)
    {
      for(int i = destinationIndex;i <= indexOfCarToMove; i++)
      {
        tempList.add(inventory.get(i));
      }
      System.out.println(tempList);
      inventory.set(destinationIndex,tempList.get(tempList.size()-1));
      System.out.println(inventory);
      for(int i = 0; i<tempList.size()-1;i++)
      {
        inventory.set(destinationIndex+i+1,tempList.get(i));
      }
    }
  }




}

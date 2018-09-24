/*
  An array with duplicate entries. Find an element with no duplicates.
  The power of Set in proving objects similar or different cannot be measured.
  
  If all objects are different or all objects are same, set.size() will immediately give you the answer.
  Clever fallbacks built into the structure like removing any element or returning false when adding isn't possible provides extra oomph 
  to this structure.
  
  I wish there was a better way of accessing elements other than set.iterator().next();
  
  Also keep note of it's cousins when order of entry is important - LinkedHashSet or when Sorting is important as 
  SortedSet<String> sortedSet = new TreeSet<String>();
  
*/


import java.util.*;
public class DroneDelivery{
    public static int findUniqueDeliveryId(int [] deliveryIds){
        Set<Integer> set=new HashSet<Integer>();
        for(int i : deliveryIds){
           if(!set.add(i)){
               set.remove(i);
           } 
        }

        if(set.isEmpty()){
            throw new NoSuchElementException("All deliveries made");
        }

        return set.iterator().next();
    }
}

This uses O(N) space in the worst case and O(N) time 


For a O(1) space solution, but this solution is not extensible and can only find the element if that is the only one that has no duplicate.
If there are more drones missing, this solution won't work

  public static int findUniqueDeliveryId(int[] deliveryIds) {

        int uniqueDeliveryId = 0;
    
        for (int deliveryId: deliveryIds) {
            uniqueDeliveryId ^= deliveryId;
        }
    
        return uniqueDeliveryId;
    }

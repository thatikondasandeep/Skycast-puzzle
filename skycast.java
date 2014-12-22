/*skycast- author sandeep */
package skycast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Skycast {

    private int count = 0;

    public int countNoOfClicks(String range, String skipList, String favourite) throws IOException {

        int previousNumber = 0;
        int previousPreviousNumber = 0;
        Set<Integer> blocked = new HashSet<>();
        ArrayList<Integer> allowed = new ArrayList<>();
        
        //taking input for start and end numbers
        StringTokenizer limits = new StringTokenizer(range);
        int startNumber = Integer.parseInt(limits.nextToken());
        int endNumber = Integer.parseInt(limits.nextToken());
        if (startNumber < 0 || startNumber > 10000 || endNumber < startNumber || endNumber > 10000) {
            System.out.println("range should equal or below 10,000 or above 0 ");
            System.out.println("Enter input again");
            System.exit(0);
        }
        
        // taking input blocked list element
        StringTokenizer st = new StringTokenizer(skipList);
        int blockedCount = Integer.parseInt(st.nextToken());
        if (blockedCount > 40) {
            System.out.println("blocked channel list not more than 40 enter again");
            System.exit(0);
        }
        for (int i = 0; i < blockedCount; i++) {
            blocked.add(Integer.parseInt(st.nextToken()));
        }
        
        // taking input wished list of channels
        StringTokenizer st1 = new StringTokenizer(favourite);
        int allowedCount = Integer.parseInt(st1.nextToken());
        if (allowedCount < 1 || allowedCount > 50) {
            System.out.println("favourite channels should be between 1-50 range");
            System.exit(0);
        }
        int sample;
        for (int i = 0; i < allowedCount; i++) {
            sample = Integer.parseInt(st1.nextToken());
            if (checkrange(sample) || blocked.contains(sample) || sample < startNumber || sample > endNumber) {
                System.out.println("check the entered favourite channel nember");
                System.exit(0);
            }
            allowed.add(sample);
        }
        
        //Counting the clicks for eac and every favourite channel 
        for (int i = 0; i < allowed.size(); i++) {
            int status = countDigits(allowed.get(i));
            if (!skipElement(blocked, previousNumber, allowed.get(i))) {
                if (!(elementIsInBoundaries(allowed.get(i), startNumber, endNumber, status, previousNumber, previousPreviousNumber))) {
                    if (!elementIsLessThanGreaterThanPreviousSet(allowed.get(i), status, previousNumber, previousPreviousNumber)) {
                        count += status;
                    }
                }
            }
            previousPreviousNumber = previousNumber;
            previousNumber = allowed.get(i);
        }
        return count;
    }

    
    /**
     * Check the given channel with in the range or not  
     * @param current current channel to visit
     * @return true or false based on the condition
     */
    public boolean checkrange(int current) {
        if (current < 1 || current > 10000) {
            return true;
        }
        return false;
    }

    /**
     * Check the element in nearer to the previous number
     * @param current current channel to visit
     * @param size number of digits in the current channel
     * @return returns true if the current channel is less or greater than with
     * small distance
     */
    public boolean elementIsLessThanGreaterThanPreviousSet(int current, int size, int previousNumber, int previousPreviousNumber) {
        if (current == previousNumber) {
            return true;
        } else if (current - 1 == previousNumber || current + 1 == previousNumber || current == previousPreviousNumber) {
            count = count + 1;
            return true;

        } else {
            for (int j = 1; j < size; j++) {
                if (current - j == previousPreviousNumber || current + j == previousPreviousNumber) {
                    count = count + j + 1;
                    return true;
                } else if (current - j == previousNumber || current + j == previousNumber) {
                    count = count + j;
                    return true;
                }
            }
            return false;
        }

    }

    /**
     * Check the current element in the boundaries region 
     * @param current current channel to visit
     * @param startNumber starting number in the given range
     * @param endNumber ending number in the given range
     * @param size total number of digits current channel have
     * @param previousNumber previous visited channel
     * @return true if the channel with in the boundary region
     */
    public boolean elementIsInBoundaries(int current, int startNumber, int endNumber, int size, int previousNumber, int previousPreviousNumber) {
        int diff = endNumber - startNumber;
        for (int j = 0; j < size; j++) {
            if (((previousNumber + (diff - j)) == current) || (previousNumber - (diff - j) == current)) {
                count = count + j + 1;
                return true;

            } else if ((previousPreviousNumber + (diff - j) == current) || (previousPreviousNumber - (diff - j) == current)) {
                count = count + j + 2;
                return true;
            }

        }

        return false;

    }

    /**
     * Check the is there any blocked elements in between previous and present number
     * @param prev previous visited element
     * @param element current element
     * @return
     */
    public boolean skipElement(Set<Integer> blocked, int previousNumber, int current) {
        boolean status = false;
        if (previousNumber!=0) {
            for (int i = 1; i <blocked.size() + 1; i++) {
                if (((current > previousNumber) && blocked.contains(previousNumber + i)) || ((current < previousNumber) && blocked.contains(previousNumber - i))) {
                    if (((current > previousNumber) && (previousNumber + (i + 1)) == current) || (((current < previousNumber)) && (previousNumber - (i - 1)) == current)) {
                        status = true;
                        count += 1;
                        return status;
                    }
                }
            }
        }
        return status;
    }

    /**
     * Counts the number of digits in the given channel
     * @param element input as given integer numbers
     * @return it returns the total number digits in the input string
     */
    public int countDigits(int current) {
        int totalDigits = 1;
        if (current > 0 && current < 10) {
            return totalDigits;
        }
        while (current > 0) {
            if (current / 10 > 0) {
                totalDigits += 1;
            }
            current /= 10;
        }

        return totalDigits;

    }
}

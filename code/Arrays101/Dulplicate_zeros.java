import java.util.Arrays;
import java.util.Scanner;
import java.lang.StringBuilder;
/**
*Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
*/
public class duplicate_Zeros {
	public static void main(String[] args) {
		int[] arr = {1,0,2,3,0,4,5,0};
		Solution solution = new Solution();
		solution.duplicateZeros(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
class Solution {
    public void duplicateZeros(int[] arr) {
		int count = 0;
		int[] zeros = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
			zeros[i] = count;
			if (arr[i] == 0) {
				count++;
			}
        }
		int[] result = new int[arr.length+count];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				result[i+zeros[i]] = 0;
				result[i+zeros[i]+1] = 0;
			} else {
				result[i+zeros[i]] = arr[i];
			}
		}
		System.arraycopy(result, 0, arr, 0, arr.length);
    }
}
class de_Solution {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}

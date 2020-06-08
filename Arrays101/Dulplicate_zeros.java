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
class good_Solution {
    public void duplicateZeros(int[] arr) {
        int length_ = arr.length-1;
        int pos_dups = 0;

        //counting the number of zeroes to be duplicated
        for(int left=0; left<=length_-pos_dups; left++) {
        	if(0==arr[left]) {

        		//Edge case
        		if(left==length_-pos_dups) {
        			arr[length_]=0;
        			length_--;
        			break;
        		}

        		pos_dups++;
        	}
        }

        for(int i=length_-pos_dups; i>=0; i--) {
        	if(arr[i]==0) {
        		arr[i+pos_dups] = 0;
        		pos_dups--;
        		arr[i+pos_dups] = 0;
        	} else {
        		arr[i+pos_dups] = arr[i];
        	}
        }
    }
}

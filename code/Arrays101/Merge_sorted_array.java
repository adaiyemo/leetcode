public class Merge_sorted_array {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] n1 = {1,2,3,0,0,0};
		int[] n2 = {2,5,6};
		solution.merge(n1,3,n2,3);
		for (int i = 0; i < n1.length; i++) {
			System.out.print(n1[i] + " ");
		}
	}
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        	int x = 0;
			int y = 0;
			int[] a = new int[m];
			System.arraycopy(nums1,0,a,0,m);
			int tmp = 0;
			while (x<m && y<n) {
				if (a[x] < nums2[y]) {
					nums1[tmp] = nums1[x];
					x++;
				} else {
					nums1[tmp] = nums2[y];
					y++;
				}
				tmp++;
			}
			if (x < m) {
				System.arraycopy(a,x,nums1,tmp,m-x);
			} else {
				System.arraycopy(nums2,y,nums1,tmp,n-y);
			}
    }
}
class default_Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m-1, j = n-1, k = nums1.length-1) {
			if (i>=0 && j>=0) {
				if (nums1[i] >= nums2[j]) {

				}
			}
		}
	}
}

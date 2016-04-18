package arithmetic;

/**
 * 二分查找算法小事例
 * 
 * @author Administrator
 *
 */
public class BinarySearch {
	public static int rank(int key, int[] a){
		int begin = 0;
		int end = a.length -1;
		while(begin <= end){
			int mid = begin + (end - begin) / 2;
			if (key < a[mid])
				end = mid - 1;
			else if (key > a[mid])
				begin = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(rank(21,a));
	}
}

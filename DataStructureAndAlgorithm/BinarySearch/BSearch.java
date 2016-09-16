package DataStructureAndAlgorithm.BinarySearch;
/**
 * ¶Ô°ëËÑË÷µİ¹éËã·¨
 * @author zhen
 *
 */
public class BSearch {
	//¶Ô°ëËÑË÷µİ¹éËã·¨
	public String search(int x,int[] array){
		int result=binarySearch(x,array,0,array.length-1);
		if(result==-1)
			return "No Present!";
		return array[result]+" find success!";
	}
	private int binarySearch(int x,int[] array,int low,int high){
		if(low<=high){
			int m=(low+high)/2;
			if(x<array[m]){
				return binarySearch(x, array, low, m);
			}
			else if(x>array[m]){
				return binarySearch(x, array, m, high);
			}else return m;
		}
		return -1;
	}
	//¶Ô°ëËÑË÷µü´úËã·¨
	public String bSerach(int x,int[] array){
		int mid,low=0,high=array.length-1;
		while(low<=high){
			mid=(low+high)/2;
			if(x>array[mid]){
				low=mid+1;
			}else if(x<array[mid]){
				high=mid-1;
			}else
				return array[mid]+" find success!";
		}
		return "No present!";
		
	}
}

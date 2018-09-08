package adapter;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 二分查找：适配者
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-20     zyh           v1.0.0               修改原因
 */
public class  BinarySearch {
    public int binarySearch(int array[],int key){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if(midVal < key){
                low = mid + 1;
            }else if(midVal > key){
                high = mid - 1;
            }else{
                return 1;
            }
        }
        return -1;
    }
}

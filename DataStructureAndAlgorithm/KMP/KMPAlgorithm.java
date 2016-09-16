/**
 * KMP模式匹配  O(m+n)
 */
package DataStructureAndAlgorithm.KMP;
/**
 * KMP模式匹配关键是要找准回溯位，即要高效准确求得find（Fail函数）数组。
 * @author zhen
 *
 */
public class KMPAlgorithm {
	private int[] find;
	//target:主串，mode：子串;返回值表示在主串哪个位置匹配（从0开始），-1表示无法匹配。
	public int findKMP(String target,String mode){
		if(mode==null||target==null||mode.length()>target.length()){
			return -1;
		}
		failFind(mode);
		int j=0,i=0,m=target.length(),n=mode.length();
		char[] targetArray=target.toCharArray();
		char[] modeArray=mode.toCharArray();
		while(i<m&&j<n){
			//j==-1或相等时，i、j均后移一位
			if(j==-1||modeArray[j]==targetArray[i]){
				i++;
				j++;
			}else{
				j=find[j];//到达失配点，j回溯到find[j]
			}
		}
		return ((j==n)?i-n:-1);//返回匹配点位置
	}
	private int[] failFind(String mode){
		find=new int[mode.length()];
		int j=0,k=-1,n=mode.length();
		System.out.println(n);
		find[0]=-1;
		char[] modeArray=mode.toCharArray();
		while(j<n-1){
			//k==-1或mode[i]=mode[j]，j、k个扩展一位
			if(k==-1||modeArray[j]==modeArray[k]){
				j++;k++;
				//改进的失败函数：eg:target[7]='a',mode[7]='b',target[7]!=mode[7],取j=find[7]=4;
				//即第二趟从mode[4]与target[7]继续比较，由于mode[4]=mode[7]='b'；因此mode[7]!=target[7],
				//所以本次回溯无意义！同理类推。因此改进失败函数计算方法：在求得k值后，不是马上将k值存放到find[j]中，
				//而是判断比较mode[k]和mode[j]是否相等？若不等，将k存入find[j];
				//若相等，将find[k]存入find[j]
				if(modeArray[j]==modeArray[k]){
					find[j]=find[k];
				}else{
					find[j]=k;
				}
			}else{
				k=find[k];
			}
		}
		return find;
	}
}

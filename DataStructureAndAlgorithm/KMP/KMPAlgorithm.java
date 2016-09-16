/**
 * KMPģʽƥ��  O(m+n)
 */
package DataStructureAndAlgorithm.KMP;
/**
 * KMPģʽƥ��ؼ���Ҫ��׼����λ����Ҫ��Ч׼ȷ���find��Fail���������顣
 * @author zhen
 *
 */
public class KMPAlgorithm {
	private int[] find;
	//target:������mode���Ӵ�;����ֵ��ʾ�������ĸ�λ��ƥ�䣨��0��ʼ����-1��ʾ�޷�ƥ�䡣
	public int findKMP(String target,String mode){
		if(mode==null||target==null||mode.length()>target.length()){
			return -1;
		}
		failFind(mode);
		int j=0,i=0,m=target.length(),n=mode.length();
		char[] targetArray=target.toCharArray();
		char[] modeArray=mode.toCharArray();
		while(i<m&&j<n){
			//j==-1�����ʱ��i��j������һλ
			if(j==-1||modeArray[j]==targetArray[i]){
				i++;
				j++;
			}else{
				j=find[j];//����ʧ��㣬j���ݵ�find[j]
			}
		}
		return ((j==n)?i-n:-1);//����ƥ���λ��
	}
	private int[] failFind(String mode){
		find=new int[mode.length()];
		int j=0,k=-1,n=mode.length();
		System.out.println(n);
		find[0]=-1;
		char[] modeArray=mode.toCharArray();
		while(j<n-1){
			//k==-1��mode[i]=mode[j]��j��k����չһλ
			if(k==-1||modeArray[j]==modeArray[k]){
				j++;k++;
				//�Ľ���ʧ�ܺ�����eg:target[7]='a',mode[7]='b',target[7]!=mode[7],ȡj=find[7]=4;
				//���ڶ��˴�mode[4]��target[7]�����Ƚϣ�����mode[4]=mode[7]='b'�����mode[7]!=target[7],
				//���Ա��λ��������壡ͬ�����ơ���˸Ľ�ʧ�ܺ������㷽���������kֵ�󣬲������Ͻ�kֵ��ŵ�find[j]�У�
				//�����жϱȽ�mode[k]��mode[j]�Ƿ���ȣ������ȣ���k����find[j];
				//����ȣ���find[k]����find[j]
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

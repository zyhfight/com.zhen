package DataStructureAndAlgorithm.KMP;

public class KMPMain {

	public static void main(String[] args) {
		KMPAlgorithm obj=new KMPAlgorithm();
		String target="abcabcaabcabcabbac";
		String mode="abcabcabbac";
	System.out.println(obj.findKMP(target, mode));	
	}

}

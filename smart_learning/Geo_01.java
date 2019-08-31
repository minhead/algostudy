// 2���� ��� ���� N���� ������ �̷���� �ܼ� �ٰ��� �־���, �ٰ��� ���� ���϶�
// a,b ���� : a���� *b����*sin��Ÿ = ����
// a,b ���� = ax*by -bx*ay 
// a,b ���� *1/2 = �ﰢ������

package smart_learning;

public class Geo_01 {
	static int X[],Y[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans = 0;
		int N = 5;
		X = new int[N+1];
		Y = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			int j = i % N + 1;
			ans = ans+(long)X[i]*Y[j]-(long)X[j]*Y[i];
		}
		ans = Math.abs(ans);
		System.out.println(ans/2);
		

	}

}

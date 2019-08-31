//�����۽� ������ ������ ����.
//1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����. 
//���� ������� K��° ����� �����Ѵ�. �� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. 
//�� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. ������ ������� ���ŵǴ� ������ (N, K)-�����۽� �����̶�� �Ѵ�. 
//���� ��� (7, 3)-�����۽� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.
//N�� K�� �־����� (N, K)-�����۽� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pb11866 {

	static int N; // �����
	static int K; // ���� ����

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		System.out.print("<");
		while (!q.isEmpty()) {
			for(int i=1;i<K;i++) {
			q.add(q.poll());
			}
			int a = q.poll();
			System.out.print(a);
			if (q.isEmpty())
				break;
			System.out.print(", ");
		}
		System.out.println(">");

	}

}

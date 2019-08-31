//N���� �л����� Ű ������� ���� ������� �Ѵ�. �� �л��� Ű�� ���� �缭 �����ϸ� �����ϰ�����, 
//������ ����� ��� �� �л��� Ű�� ���ϴ� ����� ����ϱ�� �Ͽ���. 
//�׳����� ��� �л����� �� ���� �� ���� �ƴϰ�, �Ϻ� �л����� Ű���� ���� ���Ҵ�.
//�Ϻ� �л����� Ű�� ���� ����� �־����� ��, ���� ����� ���α׷��� �ۼ��Ͻÿ�.
//�Է�
//ù° �ٿ� N(1��N��32,000), M(1��M��100,000)�� �־�����. M�� Ű�� ���� ȸ���̴�. 
//���� M���� �ٿ��� Ű�� ���� �� �л��� ��ȣ A, B�� �־�����. �̴� �л� A�� �л� B�� �տ� ���� �Ѵٴ� �ǹ��̴�.
//�л����� ��ȣ�� 1������ N���̴�.
//���
//ù° �ٺ��� �տ������� ���� ���� ����� ����Ѵ�. ���� ���� ������ ��쿡�� �ƹ��ų� ����Ѵ�.

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pb2252_lineup {
	
	static int N,M;//�л� ��, �񱳰���
	static int D[];
	static int inDegree[];//�������� �迭
	static ArrayList<Integer>[] al;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		que = new LinkedList<>();
		inDegree = new int[N+1];
		for(int i =0; i<=N;i++) {
//			al.add(new ArrayList<Integer>());
		}
		int a,b;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			a= Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			inDegree[b]++;
		}

	}
	static void topologySort() {
		//���������� 0�� ��带 ť�� ����
		for(int i = 1; i<=N;i++) {
			if(inDegree[i]==0) {
				que.add(i);
			}
		}
		//������ ������ ����Ƿ��� ��Ȯ�� n���� ��带 �湮�մϴ�.
		for(int i = 1; i<=N; i++) {
			int x = que.peek();
			que.poll();
			D[i] = x;
		}
	}

}

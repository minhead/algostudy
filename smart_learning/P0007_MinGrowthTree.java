package smart_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
//�ּҽ���Ʈ�� MST
public class P0007_MinGrowthTree {
	private static class Edge {
		int a, b, c;

		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

	}

	static int par[];
	static int N;
	static int M;
	static int K;
	static int a, b, c;

	static int find(int n) { // ��ξ���
		if (par[n] == n) {
			return n;
		}
		return par[n] = find(par[n]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //������ �� 
			M = Integer.parseInt(st.nextToken()); //���� �����ϴ� ������ ��
			K = Integer.parseInt(st.nextToken()); //�Ǽ������� ������ ��

//������ �����ϴ� Arraylist
			ArrayList<Edge> edges = new ArrayList<>();
			long ans = 0;
			for (int i = 1; i <= M; i++) {//������ �����ϴ� ���� M���� ���� abc �Է�
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b, -c)); //���θ� �����ϴ� ��� c, �� ���θ� ä���ϴ� ��� ���θ� ���� ���ص� �ǹǷ� ����� -��
				ans = ans + c; //���� ���θ� ��� �����س��� �����ϱ⶧���� ��뿡 c�� ����
			}
			for (int i = 1; i <= K; i++) {// �Ǽ������� ���� ����Ʈ ����
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b, c));
			}
			//���� �����ϱ�
			Collections.sort(edges, new Comparator<Edge>() {
				public int compare(Edge a, Edge b) {
					return a.c -b.c;
				}
			});
			
			par = new int[N+1]; //��� �迭 �����
			for(int i = 1; i<=N; i++) {
				par[i] = i;//�迭�� �� �ε����� �� ��ȣ�� ��忡���� ���� ��´�.
			}
			for(Edge e: edges) { // UNION ..��� ��������  
				int a = find(e.a); //�� ������ ���� �θ��带 a�� ��´�
				int b= find(e.b); //�� ������ ���� �θ��带 b�� ��´�
				if(a==b) //�� �� �θ��尡 ���ٸ� ���������̹Ƿ�
					continue; // �ش� ������ ���õ��� �ʴ´�
				par[b] = a;
				ans = ans+e.c; //������ ���õǸ� ans�� ���ó���� �Ѵ�.
						
			}
			
			System.out.println("#"+test_case+" "+ans);
		}

	}
}
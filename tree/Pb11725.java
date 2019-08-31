package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Ʈ���� �θ� ã��
//��Ʈ ���� Ʈ���� �־�����. �̶�, Ʈ���� ��Ʈ�� 1�̶�� ������ ��, �� ����� �θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//�Է�
//ù° �ٿ� ����� ���� N (2 �� N �� 100,000)�� �־�����. ��° �ٺ��� N-1���� �ٿ� Ʈ�� �󿡼� ����� �� ������ �־�����.
//���
//ù° �ٺ��� N-1���� �ٿ� �� ����� �θ� ��� ��ȣ�� 2�� ������ ������� ����Ѵ�.
public class Pb11725 {

	static class Edge {
		int from;
		int to;
		public Edge(int from, int to) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
		}
	}
	static int N;
	static ArrayList<Integer>[] list;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		StringTokenizer st;
		int a;
		int b;
		for(int i = 1; i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();

		int start;
		q.offer(1);
		int[] par = new int[N+1];
		while(!q.isEmpty()) {			
			start = q.poll();
			if(!visited[start]) {
				visited[start]=true;
				for(int i=0;i<list[start].size();i++) {
					int x = list[start].get(i);
					if(!visited[x]) {
					q.offer(x);
					par[x] = start;
					}
				}
			}
		}
		for(int i = 2; i<=N;i++)
		System.out.println(par[i]);
		
		
		
		
	}

}

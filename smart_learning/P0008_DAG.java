package smart_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P0008_DAG {

	static int N,M,a,b,c;
	static ArrayList<Integer>[] con, from,fromv;
	static int in[];
	static int D[];
	static ArrayList<Integer> order;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int test_case = 1; test_case<=T;test_case++) {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		in = new int[N+1];
		con = new ArrayList[N+1];
		for(int i = 0; i<M;i++) { //M���� ������ ���� ����
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // ���� �Է¹޴´�
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			con[a].add(b); //��������Ʈ ���� a->b �� ���� ����, b indegree
			in[b]++;
			from[b].add(a);//b�ε����� ������ ����
			fromv[b].add(c);//b�ε����°��� ����ġ
			
		}
		D = new int[N+1]; //�������� �ִ� D �迭����
		for(int i = 1; i<=N; i++) {
			if(i==1|| in[i]>0) //i�� ������ ������ ������
				D[i] = 0; //0�ʱ�ȭ
			else 
				D[i]=(int)2e9; //���Ѱ����� �ʱ�ȭ
		}
		//�������� ����
		order = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++){ //i�� ������ ������ ������ queue�� i�߰�
			if(in[i]==0)
				queue.add(i);
		}
		while(!queue.isEmpty()) { //queue �� ����
			int q = queue.poll(); //queue���� �ϳ� �̾Ƽ�
			order.add(q);
			for(int t: con[q]) { //queue�� ����� t�����ؼ� ���� ���� indegree�� ���ҽ�����
				if(--in[t]==0) // indegree ���ҽ�Ų ���� 0�̸�
					queue.add(t); // queue�� �߰�
			}
		}
		//�������� ��
		//order���� �������� ������� ����Ǿ�����
		for(int n:order) {
			for(int i=0; i<from[n].size();i++) {
				int t = from[n].get(i);
				int v = fromv[n].get(i);
				D[n]= Math.max(D[n], D[t]+v);
			}
			D[n] = Math.min(D[n], (int)2e9);
		}

		System.out.println("#"+test_case+ " "+D[N]);
		
	}
	}
}

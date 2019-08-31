package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

//�ʱ⿡ {0}, {1}, {2}, ... {n} �� ���� n+1���� ������ �̷�� �ִ�. ���⿡ ������ �����, �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ����� Ȯ���ϴ� ������ �����Ϸ��� �Ѵ�.
//������ ǥ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
public class Pb1717 {

	static int n;
	static int m;
	static int par[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		par = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			par[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0) {// ������
				union(b, c);

			} else {// �������ԵǾ��ִ��� �˻�
				if (find(b) == find(c)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x != y)
			par[x] = y;

	}

	static int find(int a) {
		if (par[a] == a) {
			return a;
		} else {
			par[a] = find(par[a]);
			return par[a];
		}
	}
}

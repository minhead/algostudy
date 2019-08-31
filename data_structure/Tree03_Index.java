package data_structure;
//���� �ּҰ� ����
//N���� �����Ͱ� �־����� ��, Q ���� ������ �����ϴ� �ڵ带 �ۼ��϶�
//������ 3���� ���� c,x,y�� �̷���������� ������ ������ c�� 0�� ���
//X~Y ������ �ּҰ��� ����ϰ� C�� 1�ΰ�� X��° �����͸� Y�� �����Ѵ�

import java.util.Scanner;

public class Tree03_Index {
	static final int MAX_TREE = 262144, MAX_N = 100001;
	static int N,Q;
	static int tree[] = new int [MAX_TREE];
	static int data[] = new int [MAX_N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //������ ��
		Q = sc.nextInt(); //������
		for(int i=0;i<N;i++) {
			data[i] = sc.nextInt();
		}
		//ó������ N���� ũ�ų� ���� 2�� ������
		int tmpN;
		int h=0;
		for(tmpN =1; tmpN<=N;tmpN*=2) {
			h++;
			//1-2-4-8-16 ... �����ϸ鼭 N���� ū 2���������� ���ؼ� tmpN�� �ִ´� Ʈ�� ���̴� h
		}
		for(int i=0;i<N;i++) {
			tree[i+tmpN]=data[i];//������带 ����ֱ� 
		}
		for(int i=tmpN-1;i>1;i--) {//�ؿ������� Ʈ���� �ö󰡸鼭 �ּҰ��� ����ִ´�
			tree[i] = Math.min(tree[i*2],tree[i*2+1]); //����, ������ ����� �ּҰ��� tree[i]�� �ִ´�
		}
		//���� �Է� �� ó��
		for(int i = 1; i<=Q; i++) {
			int c,x,y;
			c = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			//����
			if(c==1) { //x��° �����͸� Y�� �����Ѵ�
				tree[x+tmpN-1]=y;
				x = (x+tmpN-1)/2; //X�� �θ���� �̵��ϸ鼭 �ּҰ��� �������ش�
				while(x!=0) {
					tree[x] = Math.min(tree[x*2], tree[x*2+1]);
					x/=2;
				}
			}
			//������ ���ϱ�
			if(c==0) {
				int min = 2000000000;
				x = x+tmpN-1;
				y = y+tmpN-1;
				while(x<=y) {
					if(x%2==1)
						min =  Math.min(tree[x], min);
					if(y%2==0)
						min =  Math.min(tree[y], min);
					x = (x+1)/2;
					y = (y-1)/2;
				}
				System.out.println(min);
			}
		}
	}

}

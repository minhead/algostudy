//���� ��ġ
//2���� ��鿡 N���� ������ �̷���� �ٰ����� �־�����
//�׸��� �� ���� �� P1,P2�� �־����µ�
//��P1,P2�� �ٰ����� ���ο� �ִ��� �ܺο� �ִ��� �Ǻ��ϴ� ����
//��, �� P1,P2�� �־��� �ٰ����� ���� ���� �������� �ʴ´�
//�� �ʳ��� �� P�� �������� �����ϴ� ������ ������ ����
//�����ϴ� ������ ������ Ȧ���� P�� �ٰ��� �ȿ� �ְ�, ¦����� P�� �ٰ��� �ܺο� �ִ�
//����ó�� 4���� 
//�������� ������ ������ ���
//�������� ������ ������ ���
//�������� ���а� ��ġ�� ������ ���
//���ܰ� �Ȼ���� �������� �׸��� ��
// ���� ���� P�� �������� �ٰ��� �ۿ� �ִ� ���� Ȯ���� �� Q�� ��� ���� PQ�� ������ �� ����
// ������ ������ ������ �ʴ� ������(���� PQ) �����
// �־����� �ٰ����� ������ ���� ��ǥ
// Q�� ��ǥ�� (10^9 +1, Py+1)�̶� ����
// ��Q�� �ٰ��� �ۿ� �ִ� ���� Ȯ���ϴ�(�Է°����� ��ǥ ���� ���̴�)
// ���� PQ�� �� P,Q�� �����ϰ� ���̿� ���� ��ǥ�� ������ ���� ������ �ʴ´�
// �� �ٰ����� ��� �־����� ���� �ٰ����� ������ ������ ������ �ʴ´�
//ccw= (bx-ax)(cy-ay)-(cx-ax)(by-ay)
//���б����Ǻ� -> ab�� cd�� �����Ѵ� = ccw(a,b,c)*ccw(a,b,d) = -1 && ccw(c,d,a)*ccw(c,d,b)=-1
package smart_learning;

public class Geo_02 {

	static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {
		long k = (long) (bx - ax) * (cy - ay) - (long) (cx - ax) * (by - ay);
		if (k > 0)
			return 1;
		if (k < 0)
			return -1;
		return 0;
	}

	static boolean is_cross(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		if (ccw(ax, ay, bx, by, cx, cy) * ccw(ax, ay, bx, by, dx, dy) < 0
				&& ccw(cx, cy, dx, dy, ax, ay) * ccw(cx, cy, dx, dy, bx, by) < 0) {
			return true;
		}
		return false;
	}
	static boolean check(int x1, int y1) {//x1->P��ǥ x2->Q��ǥ
		int x2 = (int)1e9+1;
		int y2 = y1+1;
		int ret = 0;
		for(int i=1; i<=N;i++) {
			int j = i%N+1;
			if(is_cross(x1,y1,x2,y2,X[i],Y[i],X[j],Y[j])) //ij���� pq���� �����ϴ��� ȭ��
				ret++;
		}
		if(ret%2==1) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

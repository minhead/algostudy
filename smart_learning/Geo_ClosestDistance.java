//������ ���� ��ġ�� ���� ������ �ִ�. �� �� P(x1,y1) Q(x2,y2)�� ������ �Ÿ��� SQRT[(x1-x2)^2 + (y1-y2)^2]�� �����Ѵٸ�,
//��� ���� ���̿���, ���� ����� �Ÿ��� ã�Ƴ��ÿ�.
//��������
//�� ������ ���� ���� ã�Ƴ��� �ð��� 0.5��(500ms �̳�)�� ��
//�Է�
//�Է¹����� �ؽ�Ʈ���Ϸ� �־�����, ���ϳ� ������ ������ ����
// - ù�� ° �࿡, ��ü ���� ������ ������
// - �ι�° ����� ������ ���� ����
//   . ���� ���� ������
//   . �� ���� �ٿ� �������� ���еǾ� x,y���� ����

package smart_learning;

import java.util.Arrays;
import java.util.Comparator;

static class Point{
	int idx;
	int x,y;
	public Point(int idx,int x,int y) {
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
	public double dist(Point b) {
		return Math.sqrt(Math.pow((x-b.x),2) +Math.pow(y-b.y, 2));
	}
}

public class Geo_ClosestDistance {

	//1. ������ �迭�� Point ��ü �迭�� ��ȯ
	//2. xPoints�� x�� �������� ����
	//3. ��������� ȣ���ϸ鼭 �ּһ��̰Ÿ��� ����� closest()�޼��� ȣ��
	private static double closestDistance(int[][] p) {
		if(p == null) {
			return -1;
		}
		int n = p.length;
		if(n==1)
			return -1;
		// 1.������ �迭�� Point ��ü �迭�� ��ȯ
		Point[] points = new Point[n];
		for(int i=0;i<n;i++) {
			points[i] = new Point(i,p[i][0],p[i][1]); //index,x��ǥ,y��ǥ
		}
		
		//2. x�� �������� ����
		Point[] xPoints = new Point[n];
		System.arraycopy(points, 0, xPoints, 0, n);
		Arrays.sort(xPoints, new Comparator<Point>() {
			
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

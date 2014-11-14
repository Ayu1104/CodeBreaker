import java.util.Random;

class RandNo4 {

		private static int No;
		private int num;
		
		static{
			Random rand = new Random();
			No = (rand.nextInt(10));
		}
		
		//コンストラクタ
		public RandNo4(){
			num = No;
		}
		
		//値を設定しなおすメソッド
		public void resetNo4(int x,int y,int z){
			while(No == x || No == y || No == z) { //1桁目、2桁目、3桁めと違う数値が出るまでループ抜けられない
				Random rand = new Random();
				No = (rand.nextInt(10));
			}
		}
		
		public int getNo4(){
			return No;
		}
}
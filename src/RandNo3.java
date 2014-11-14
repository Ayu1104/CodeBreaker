import java.util.Random;

class RandNo3 {

		private static int No;
		private int num;
		
		static{
			Random rand = new Random();
			No = (rand.nextInt(10));
		}
		
		//コンストラクタ
		public RandNo3(){
			num = No;
		}
		
		//値を設定しなおすメソッド
		public void resetNo3(int x,int y){
			while(No == x || No == y) { //1桁目、2桁目と違う数値が出るまでループ抜けられない
				Random rand = new Random();
				No = (rand.nextInt(10));
			}
		}
	
		public int getNo3(){
			return No;
		}
}
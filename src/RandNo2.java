import java.util.Random;

class RandNo2 {

		private static int No;
		private int num;
	
		static{
			Random rand = new Random();
			No = (rand.nextInt(10));
		}
	
		//コンストラクタ
		public RandNo2(){
			num = No;
		}
		
		//値を設定しなおすメソッド
		public void resetNo2(int x){
			while(No == x) { //1桁目と違う数値が出るまでループ抜けられない
				Random rand = new Random();
				No = (rand.nextInt(10)); 
			}
		}
		public int getNo2(){
			return No;
		}
}
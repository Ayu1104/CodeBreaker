import java.util.Random;

class RandNo1 {

		private static int No;
		private int num;
		
		static{
			Random rand = new Random();
			No = (rand.nextInt(9)+1); //一ケタ目に0が出ない
		}
		
		//コンストラクタ
		public RandNo1(){
			num = No;
		}
	
		public int getNo1(){
			return No;
		}
}

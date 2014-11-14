/*応用プログラミングB　中間発表課題
 数当てゲーム「コードブレイカー」
 1223138 安藤歩美
 ☆このプログラムは、コンソールのウィンドウサイズを大きくしてから実行してください
 [Code Breaker.java]*/

import java.util.Scanner;

public class CodeBreaker{
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		//ランダムな4桁の数字を作り出す
		RandNo1 C1 = new RandNo1();
		RandNo2 C2 = new RandNo2();
		RandNo3 C3 = new RandNo3();
		RandNo4 C4 = new RandNo4();
		
		int B1 = 0, B2 = 0, B3 = 0, B4 = 0;
		double num;
		int hit = 0, blow = 0; //ヒット＆ブロー
		int count = 0;
		
		System.out.println("＊ Ｃｏｄｅ　Ｂｒｅａｋｅｒ ＊");
		System.out.print("\n");
		System.out.println("＊ルール＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		System.out.println("＊4桁の数字を当ててください　　　 ＊");
		System.out.println("＊位置と数字が合っている個数がHIT ＊");
		System.out.println("＊数字のみが合っている個数がBLOW　＊");
		System.out.println("＊で表されます。それを手がかりに　＊");
		System.out.println("＊数字を予想してください　　　　　＊");
		System.out.println("＊4桁を構成する数字は重複しません ＊");
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		System.out.println("\n");
		
		//System.out.println("問題の数値"+C1.getNo1()+C2.getNo2()+C3.getNo3()+C4.getNo4());
		
		//数値が被ったら値を設定しなおすメソッドに引数を渡す
		C2.resetNo2(C1.getNo1());
		C3.resetNo3(C1.getNo1(),C2.getNo2());
		C4.resetNo4(C1.getNo1(),C2.getNo2(),C3.getNo3());
		
		//System.out.println("訂正の数値"+C1.getNo1()+C2.getNo2()+C3.getNo3()+C4.getNo4());
		
		System.out.println("↓ S T A R T ↓\n");
		System.out.print("さあ、");
		
		while(hit != 4){ //全ての数値と位置が一致するまでループ
			do{
				hit = 0;
				blow = 0;
				
				System.out.println("4桁の整数を入力せよ！");
				num = stdIn.nextDouble(); //数字を入力させる
				
				//入力された数字ひとつひとつを変数に格納
				B1 = (int)(num*0.001); //1桁目
				B2 = (int)((num-B1*1000)*0.01); //2桁目
				B3 = (int)((num-(B1*1000+B2*100))*0.1); //3桁目
				B4 = (int)(num-(B1*1000+B2*100+B3*10)); //4桁目
				
				//桁数が4桁で無い場合
				if(B1 == 0|| num > 9999 || num < 1000){ 
					System.out.println("「4桁」だよ！\n");
				}
				 //数字が被ってる場合
				else if( B1==B2 || B1== B3 || B1 == B4 || B2 == B3 || B2 == B4 || B3 == B4 ){
					System.out.println("数字は被らないようにしよう\n");
				}
				
				//正しいものが入力されるまでくり返す
			}while(B1 == 0 || num > 9999 || num < 1000 || B1==B2 || B1== B3 || B1 == B4 || B2 == B3 || B2 == B4 || B3 == B4);
			count++;
			
			//位置は違えど同じ数値がある場合
			if(B1==C2.getNo2()) blow++;
			if(B1==C3.getNo3()) blow++;
			if(B1==C4.getNo4()) blow++;
			
			if(B2==C1.getNo1()) blow++;
			if(B2==C3.getNo3()) blow++;
			if(B2==C4.getNo4()) blow++;
			
			if(B3==C1.getNo1()) blow++;
			if(B3==C2.getNo2()) blow++;
			if(B3==C4.getNo4()) blow++;
			
			if(B4==C1.getNo1()) blow++;
			if(B4==C2.getNo2()) blow++;
			if(B4==C3.getNo3()) blow++;
			
			//数値も位置も同じものがある場合
			if(B1==C1.getNo1()) hit++;
			if(B2==C2.getNo2()) hit++;
			if(B3==C3.getNo3()) hit++;
			if(B4==C4.getNo4()) hit++;
			
			if(hit <= 3){
				System.out.println("　　　　　　　　　　　　　　　["+(int)(num)+"]"+"   HIT: "+hit+" BLOW: "+blow);
				System.out.println("");
				
			}
		}
		System.out.println("正解！");
		if(count == 1){
			System.out.println("えっ？正解……だと？信じられない!!");
		}else if(count>=2 && count<=5){
			System.out.println(count+"回目で正解か。カンが冴えているな");
		}else if(count>=6 && count<=10){
			System.out.println(count+"回目で正解か。素晴らしい、お見事！");
		}else if(count>=10 && count<=15){
			System.out.println(count+"回目で正解か。なかなかいい成績だ");
		}else if(count>=16){
			System.out.println(count+"回目で正解か……また、挑戦してくれ");
		}
		System.out.println("頭の体操になったかな？");
		System.out.println("\nお　し　ま　い");
	}
}


package inheritance;

public class GrandParentA {

		public int a=10;
		protected int b=20;
		private int c=30;
		int d=40;
		
		public int accessC(){
			return c;
		}
		
		private int accessA(){
			return a;
		}
		
		protected int accessD(){
			return d;
		}
		
		int accessB(){
			return b;
		}
}

import interfaces.InterfaceOne;


public abstract class PrivateAllowed {
	private int a;
	
	class B extends PrivateAllowed implements InterfaceOne{

		@Override
		public void add() {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}

package inheritance;

class childonparent {
	public String obj = "Parent";
	
}

class child extends childonparent{
	String obj = "child";
	
	public static void main(String[] args){
		childonparent p= new childonparent();
		child c = new child();
		
		System.out.println("parent obj --> " + p.obj  + "  child obj --> " + c.obj);
		
		//c=(child)new childonparent();
		
		//System.out.println("parent obj --> " + p.obj  + "  child obj --> " + c.obj);
		
		p=c;
		
		System.out.println("parent obj --> " + p.obj  + "  child obj --> " + c.obj);
		
		p= new child();
		
		System.out.println("parent obj --> " + p.obj  + "  child obj --> " + c.obj);
		
	}
	
	
}

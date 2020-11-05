package messionImpossible;

public class IMF_member {
	Point point;
	boolean rescued;
	int health;
	String name;
	public IMF_member(Point point,boolean rescued,int health,String name) {
		this.point=point;
		this.rescued=rescued;
		this.health=health;
		this.name=name;
		
	}
	public IMF_member(Point point,String name) {
		this.name = name;
		this.point=point;
		
	}
	public static void main(String[] args) {
		

	}

}

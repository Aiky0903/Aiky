
public class Tutorial {
	public static void main(String[]args)
	{
		AlienPack ap1 = new AlienPack(3);
		ap1.addAlien(new SNAKE_ALIEN(100, "Bob"), 0);
		ap1.addAlien(new OGRE_ALIEN(100, "Ali"), 1);
		ap1.addAlien(new MARSHMALLOW_MAN_ALIEN(100, "John"), 2);
		System.out.println(ap1.calculateDamage());
	}
}

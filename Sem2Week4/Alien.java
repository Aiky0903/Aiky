class Alien
{
	private int health; // 0=dead, 100=full strength
	private String name;
	private int damage;
	
	public Alien (int health, String name)
	{
		this.health = health;
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}

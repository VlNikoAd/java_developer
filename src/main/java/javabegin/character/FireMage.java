package javabegin.character;

public class FireMage extends AbstractMage {

	public FireMage(String name) {
		super(name);
	}

	@Override
	public void sayBaseSpell() {
		System.out.println("Fire!");
	}
}

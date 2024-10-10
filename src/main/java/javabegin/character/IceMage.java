package javabegin.character;

public class IceMage extends AbstractMage {

	public IceMage(String name) {
		super(name);
	}

	@Override
	public void sayBaseSpell() {
		System.out.println("Ice!");
	}
}

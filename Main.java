public class Main {
	public static void main(String[] args) {
		Human human = new Human("Hero", 100, 15);
		int zombiesKilled = 0;
		int encounterCounter = 0;
		Walking walk = new Walking();

		while(human.isAlive() && zombiesKilled < 5){
			System.out.println(walk.walkMessage());
			encounterCounter++;
			if (encounterCounter % 3 == 0){
				Zombie zombie = new Zombie("Zombie", 50, 10);
				System.out.println("You encountered: " + zombie.getName());
				Battle battle = new Battle();
				boolean result = battle.fight(human, zombie);
				if (result){
					zombiesKilled++;
					System.out.println("You killed a zombie! " + zombiesKilled + "/5.");
				}else{
					System.out.println("You have been killed!");
					break;
				}
			}
			if (zombiesKilled == 5){
				System.out.println("Congratulations! You have killed 5 zombies and won the game!");
				break;
			}
		}
		if (!human.isAlive()){
			System.out.println("You lost the game!");
		}

	}
}
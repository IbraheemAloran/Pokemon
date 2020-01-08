import java.util.*;

public abstract class Player
{
	protected String name;
	protected Pokemon[6] pokemon;
	private boolean whiteout;
	protected Pokemon activePok;
	protected Scanner sc;

	public Player(String name)
	{
		this.name = name;
		pokemon = new Pokemon[6];
		for (int i = 0; i < 6; i++)
		{
			pokemon[i] = new Pokemon();
		}
		whiteout = false;
		sc = new Scanner(System.in);
	}

	public void addRandomPokemon(ArrayList<Pokemon> poks)
	{
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
		{
			int num = rand.nextInt(poks.size());
			pokemon[i].setStats(poks.get(num));
			poks.remove(num); //Don't remove it; need to implement this
		}
	}

	public void displayPokemon()
	{
		for (int i = 0; i < 6; i++)
		{
			if (!isFainted(pokemon[i])) System.out.println((i + 1) + ". " + pokemon[i]);
		}
	}

	public Pokemon getActivePok()
	{
		return activePok;
	}

	public void setWhiteOut()
	{
		int count = 0;
		for (int i = 0; i < 6; i++)
		{
			if (isFainted(pokemon[i])) count++;
		}

		if (count == 6) whiteout = true;
	}

	public boolean isOut()
	{
		return whiteout;
	}

	public abstract void play();
	public abstract void attack();
	public abstract void switch();
}
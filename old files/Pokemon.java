public class Pokemon
{
	public void setStats(Pokemon pok)
	{
		this.name = pok.getName();
		this.type = pok.getType();
		this.fainted = pok.isFainted();
		this.status = pok.getStatus();
		this.level = pok.getLevel();
		for (int i = 0; i < 6; i++)
		{
			this.stats[i] = pok.getStats(i);
		}

		this.front = pok.getFront();
		this.back = pok.getBack();
		for (int i = 0; i < 4; i++)
		{
			this.moves[i] = pok.getMoves(i);
		}
	}

	public void displayMoves()
	{
		for (int i = 0; i < 4; i++)
		{
			System.out.println((i + 1) + ". " + moves[i]);
		}
	}
	
	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public boolean isFainted()
	{
		return fainted;
	}

	public String getStatus()
	{
		return status;
	}

	public int getLevel()
	{
		return level;
	}

	public int getStats(int i)
	{
		return stats[i];
	}

	public Image getFront()
	{
		return front;
	}

	public Image getBack()
	{
		return back;
	}

	public Move getMoves(int i)
	{
		return moves[i];
	}
}
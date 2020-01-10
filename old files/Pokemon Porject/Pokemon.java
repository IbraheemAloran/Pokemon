public class Pokemon
{
	private String name;
	private int type;
	private boolean fainted;
	private int status;
	private int level;
	private int[] stats;
	private Image front;
	private Image back;
	private Move[] moves;
	
	public Pokemon(String[] data){
	//Pikachu,11,100,6 stuff after
		String[] info = data[0].split(",");
		name = info[0];
		type = Integer.parseInt(info[1]);
		status = Integer.parseInt(info[2]);
		//level = Integer.parseInt(info[1]);
		level = 100;
		stats[0] = Integer.parseInt(info[3]);
		stats[1] = Integer.parseInt(info[4]);
		stats[2] = Integer.parseInt(info[5]);
		stats[3] = Integer.parseInt(info[6]);
		stats[4] = Integer.parseInt(info[7]);
		stats[5] = Integer.parseInt(info[8]);
		fainted = false;
		
		moves = new Move[4];
		moves[0] = new Move(data[1]);
		moves[1] = new Move(data[2]);
		moves[2] = new Move(data[3]);
		moves[3] = new Move(data[4]);
	}
	
	public boolean attack(int choice, Pokemon defending){
		return useMove(moves[choice], this, defending);
	}
	
	public void changeHP(int change){
		HP += change;
	}
		
	/*public void setStats(Pokemon pok)
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
	}*/
	
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

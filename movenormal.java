import java.util*;
import java.lang.String*;

public class movenormal extends Moves
{
	private int power = 0;
	private int accuracy = 0;
	private int pp = 0;
	private int category = 0;

	movenormal(String type, String effect, String name)
	{
		super(name, type, effect);
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public void setpower(int power)
	{
		this.power = power;
	}
	public void setaccuracy(int accuracy)
	{
		this.accuracy = accuracy;
	}
	public void setpp(int pp)
	{
		this.pp = pp;
	}
	public void setcategory(int category)
	{
		this.category = category;
	}
	public String getname()
	{
		return name;
	}
	public int getpower()
	{
		return power;
	}
	public int getaccuracy()
	{
		return accuracy;
	}
	public int getpp()
	{
		return pp;
	}
	public int getcategory()
	{
		return category;
	}






}

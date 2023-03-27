package mx.com.cursodia.jse18.mod2.sem1;

public class Articulo 
{
	private int cve_art;
	private String cat_art;
	private String nom_art;
	private float pre_art;
	private int inv_art;

	
	public Articulo(int cve_art, String cat_art, String nom_art, float pre_art, int inv_art)
	{
		this.cve_art = cve_art;
		this.cat_art = cat_art;
		this.nom_art = nom_art;
		this.pre_art = pre_art;
		this.inv_art = inv_art;
	}
	
	public int getCve_art() 
	{
		return cve_art;
	}


	public void setCve_art(int cve_art) 
	{
		this.cve_art = cve_art;
	}


	public String getCat_art() 
	{
		return cat_art;
	}


	public void setCat_art(String cat_art) 
	{
		this.cat_art = cat_art;
	}


	public String getNom_art() 
	{
		return nom_art;
	}


	public void setNom_art(String nom_art) 
	{
		this.nom_art = nom_art;
	}


	public float getPre_art() 
	{
		return pre_art;
	}


	public void setPre_art(float pre_art) 
	{
		this.pre_art = pre_art;
	}


	public int getInv_art() 
	{
		return inv_art;
	}


	public void setInv_art(int inv_art) 
	{
		this.inv_art = inv_art;
	}
	
	public String toString()
	{
		return cve_art+" "+cat_art+" "+nom_art+" "+pre_art+" "+inv_art;
	}
}
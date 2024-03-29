package mx.com.cursodia.jse18.mod2.sem1;

public class Articulo 
{
	private int cve_art;
	private String cat_art;
	private String nom_art;
	private float pre_art;
	private int inv_art;
	private int prov_art;

	public Articulo(int cve_art, String cat_art, String nom_art, float pre_art, int inv_art, int prov_art)
	{
		this.cve_art = cve_art;
		this.cat_art = cat_art;
		this.nom_art = nom_art;
		this.pre_art = pre_art;
		this.inv_art = inv_art;
		this.prov_art = prov_art;
	}
	
	int getCve_art() 
	{
		return cve_art;
	}


	void setCve_art(int cve_art) 
	{
		this.cve_art = cve_art;
	}


	String getCat_art() 
	{
		return cat_art;
	}


	void setCat_art(String cat_art) 
	{
		this.cat_art = cat_art;
	}


	String getNom_art() 
	{
		return nom_art;
	}


	void setNom_art(String nom_art) 
	{
		this.nom_art = nom_art;
	}


	float getPre_art() 
	{
		return pre_art;
	}


	void setPre_art(float pre_art) 
	{
		this.pre_art = pre_art;
	}


	int getInv_art() 
	{
		return inv_art;
	}


	void setInv_art(int inv_art) 
	{
		this.inv_art = inv_art;
	}
	
	int getProv_art()
	{
		return prov_art;
	}

	void setProv_art(int prov_art) 
	{
		this.prov_art = prov_art;
	}

	public String toString()
	{
		return cve_art+" "+cat_art+" "+nom_art+" "+pre_art+" "+inv_art;
	}
}
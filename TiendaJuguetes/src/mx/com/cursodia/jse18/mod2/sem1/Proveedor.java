package mx.com.cursodia.jse18.mod2.sem1;

public class Proveedor 
{
	private int cve_prov;
	private String nom_prov;
	private String tel_prov;
	private String email_prov;
	private String dir_prov;
	
	public Proveedor(int cve_prov, String nom_prov, String tel_prov, String email_prov, String dir_prov)
	{
		this.cve_prov = cve_prov;
		this.nom_prov = nom_prov;
		this.tel_prov = tel_prov;
		this.email_prov = email_prov;
		this.dir_prov = dir_prov;
	}

	int getCve_prov() 
	{
		return cve_prov;
	}

	void setCve_prov(int cve_prov) 
	{
		this.cve_prov = cve_prov;
	}

	String getNom_prov() 
	{
		return nom_prov;
	}

	void setNom_prov(String nom_prov) 
	{
		this.nom_prov = nom_prov;
	}

	String getTel_prov() 
	{
		return tel_prov;
	}

	void setTel_prov(String tel_prov) 
	{
		this.tel_prov = tel_prov;
	}

	String getEmail_prov() 
	{
		return email_prov;
	}

	void setEmail_prov(String email_prov) 
	{
		this.email_prov = email_prov;
	}

	String getDir_prov() 
	{
		return dir_prov;
	}

	void setDir_prov(String dir_prov) 
	{
		this.dir_prov = dir_prov;
	}
	
	public String toString()
	{
		return cve_prov+" "+nom_prov+" "+tel_prov+" "+email_prov+" "+dir_prov;
	}
}

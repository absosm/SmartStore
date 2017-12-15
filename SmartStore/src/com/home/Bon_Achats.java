package com.home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Bon_Achats {
	private int id;
	private Date date;
	private String User;
	private int code_provider;
	private double Montante;
	private double versement;
	private int Nbr_Produit ; // Nombre de produits dans le bon d'achat
	private double TVA;
	private double TIMBRE;
	private double TTC;
	private double HT;
	private double Remise;
	public Bon_Achats(){
		setDate(null);
		setUser(null);
		setCode_provider(0);
		setMontante(0.0);
		setVersement(0.0);
		setNbr_Produit(0);
		setTVA(0.0);
		setTIMBRE(0.0);
		setTTC(0.0);
		setHT(0.0);	
	}
	public Bon_Achats(int id)
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM BonAchats WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				setId(result.getInt(1));
				setDate(result.getDate(2));
				setUser(result.getString(3));
				setCode_provider(result.getInt(4));
				setMontante(result.getDouble(5));
				setVersement(result.getDouble(6));
				setNbr_Produit(result.getInt(7));
				setTVA(result.getDouble(8));
				setTIMBRE(result.getDouble(9));
				setTTC(result.getDouble(10));
				setHT(result.getDouble(11));	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date=date;
	}
	public String getUser()
	{
		return User;
	}
	public void setUser(String User)
	{
		this.User=User;
	}
	public int getCode_provider()
	{
		return code_provider;
	}
	public void setCode_provider(int code_provider)
	{
		this.code_provider=code_provider;
	}
	public double getMontante()
	{
		return Montante;		
	}
	public void setMontante(double Montante)
	{
		this.Montante=Montante;
	}
	public double getVersement()
	{
		return versement;		
	}
	public void setVersement(double versement)
	{
		this.versement=versement;
	}
	public int getNbr_Produit()
	{
		return Nbr_Produit;		
	}
	public void setNbr_Produit(int Nbr_Produit)
	{
		this.Nbr_Produit=Nbr_Produit;
	}
	public double getTVA()
	{
		return TVA;		
	}
	public void setTVA(double TVA)
	{
		this.TVA=TVA;
	}
	public double getTimbre()
	{
		return TIMBRE;		
	}
	public void setTIMBRE(double TIMBRE)
	{
		this.TIMBRE=TIMBRE;
	}
	public double getTTC()
	{
		return TTC;		
	}
	public void setTTC(double TTC)
	{
		this.TTC=TTC;
	}
	public double getHT()
	{
		return HT;		
	}
	public void setHT(double HT)
	{
		this.HT=HT;
	}
	

}

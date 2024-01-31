public class nodoArbol
{
	private int dato;
	private nodoArbol izquierdo;
	private nodoArbol derecho;
	private boolean tieneHijos; 
	public nodoArbol(int dato)
	{
		this.dato=dato;
		izquierdo = null;
		derecho = null;
		tieneHijos = false;
	}
	public int getDato()
	{
		return dato;
	}
	public nodoArbol getIzquierdo()
	{
		return izquierdo;
	}
	public void setIzquierdo(nodoArbol izquierdo)
	{
		this.izquierdo = izquierdo;
	}
	public nodoArbol getDerecho()
	{
		return derecho;
	}
	public void setDerecho(nodoArbol derecho)
	{
		this.derecho = derecho;
	}
	public boolean isTieneHijos()
	{
		return tieneHijos;
	}
	public void setTieneHijos(boolean tieneHijos)
	{
		this.tieneHijos = tieneHijos;
	}
	
}

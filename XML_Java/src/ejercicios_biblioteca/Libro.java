package ejercicios_biblioteca;

public class Libro {

	// Atributos
	private static int numLibros=0;
	private String cod;
	private String titulo;
	private String autor;
	private int fechaPublicacion;
	
	// Constructores
	public Libro() {
		numLibros++;
		this.cod = "L"+numLibros;
		this.titulo = "";
		this.autor = "";
		this.fechaPublicacion = 2000;
	}
	
	public Libro(String titulo, String autor, int fechaPublicacion) {
		numLibros++;
		this.cod = "L"+numLibros;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Libro(String cod, String titulo, String autor, int fechaPublicacion) {
		numLibros++;
		this.cod = "L"+numLibros;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	// Métodos: getters y setters
	public String getCod() {
		return cod;
	}
	
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public void setFechaPublicacion(int fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/*
	 * Devuelve una descripción del objeto Libro
	 * @return String
	 */
	@Override
	public String toString() {
		return "\nTítulo: " + titulo + "\nCódigo: " + cod + "\nAutor: " + autor + "\nAño de publicación: "
				+ fechaPublicacion;
	}
}

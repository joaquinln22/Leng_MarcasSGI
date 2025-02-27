package ejercicio_paises;

public class Pais {
	// Atributos
		int numLibros=0;
		String nombre;
		String sistema;
		int superficie;
		String moneda;
		String idioma;
		
		// Constructores
		public Pais(String nombre, String sistema,int superficie, String moneda, String idioma) {
			this.nombre = nombre;
			this.sistema = sistema;
			this.superficie = superficie;
			this.moneda = moneda;
			this.idioma = idioma;
		}
		
		// Métodos: getters y setters
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getSistema() {
			return sistema;
		}
		
		public void setSistema(String sistema) {
			this.sistema = sistema;
		}
		
		public int getSuperficie() {
			return superficie;
		}
		
		public void setSuperficie(int superficie) {
			this.superficie = superficie;
		}
		
		public String getMoneda() {
			return moneda;
		}
		
		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}
		
		public String getIdioma() {
			return idioma;
		}
		
		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}

		/*
		 * Devuelve una descripción del objeto Pais
		 * @return String
		 */
		@Override
		public String toString() {
			return "Pais: " + nombre.toUpperCase() + "\n Sistema: " + sistema + "\n Superficie: " + superficie + "km2\n Moneda: "
					+ moneda + "\n Idioma: " + idioma + "\n";
		}
}

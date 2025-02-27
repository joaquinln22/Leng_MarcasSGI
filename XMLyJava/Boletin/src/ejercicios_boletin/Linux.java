package ejercicios_boletin;

public class Linux {
	// Atributos
		private String id;
		private String nombre;
		private String web;
		private int nacimiento;
		
		// Constructores
		public Linux(String id, String nombre, String web, int nacimiento) {
			this.id = id;
			this.nombre = nombre;
			this.web = web;
			this.nacimiento = nacimiento;
		}
		
		// Métodos: getters y setters
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getWeb() {
			return web;
		}
		
		public void setWeb(String web) {
			this.web = web;
		}
		
		public int getNacimiento() {
			return nacimiento;
		}
		
		public void setNacimietno(int nacimiento) {
			this.nacimiento = nacimiento;
		}

		/*
		 * Devuelve una descripción del objeto Libro
		 * @return String
		 */
		@Override
		public String toString() {
			return "\nId: " + id + "\nNombre: " + nombre + "\nWeb: " + web + "\nNacimiento: "
					+ nacimiento;
		}
}

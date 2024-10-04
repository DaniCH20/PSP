package hilos;

public class Raton {
	
	private String nombre="";
	private int tiempo=0;
		public Raton (String nombre , int tiempo) {
			super();
			this.nombre=nombre;
			this.tiempo= tiempo;
		}
		public void comer() {
			try {
					System.out.printf("El Raton %s empieza a comer %n",nombre);
					Thread.sleep(tiempo*1000);
					System.out.printf("El Raton %s ha terminado de comer %n",nombre);
			}catch(InterruptedException e) {
					e.printStackTrace();
			}
		}
		public static void main(String []args) {
			Raton raton1=new Raton("1",4);
			Raton raton2=new Raton("2",2);
			Raton raton3=new Raton("3",6);
			Raton raton4=new Raton("4",9);
			raton1.comer();
			raton2.comer();
			raton3.comer();
			raton4.comer();
			System.out.printf("Todos los ratones han comido%n");
		}
		
}

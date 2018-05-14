import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuaImplementacaoDoGrahanScan implements ConvexHullSolver {

	@SuppressWarnings("unchecked")
	@Override
	public List<Coordinate> findConvexHull(List<Coordinate> points) throws DequeEmptyException {
		// TODO Auto-generated method stub
		
		//if(points == null) throw new Exception();
		
		//procurar como achar esse ponto P com menor Y
		Coordinate P = null;
		int i = 0;
		for(Coordinate p2 : points) {
			System.out.println("entrei");
			if(i == 0) {
				P = p2;
				i++;
			}
			if(p2.getY() < P.getY()) P = p2; //nao seria <?
		}
		
		System.out.println("P get X: " + P.getX() + " P get Y: " + P.getY());
		//ordenar o vetor pelo angulo que os pontos fazem com o ponto P em relacao ao eixo X
		ordenarVetor (points, P);
		
		int j=0;
		for(Coordinate t1 : points) {
			System.out.println("Ponto na posição J= " + j + " X= " + t1.getX() + " Y= " + t1.getY());
			j++;
		}
		
		LinkedListDeque<Coordinate> deque =  new LinkedListDeque<Coordinate>();
		
		int k= 0;
		for(Coordinate t1 : points) {
			if(k==0) deque.addFirst(t1);
			if(k<3 && k>0) deque.addLast(t1);
			
			else {
				Coordinate teste = (Coordinate) deque.getFirst();
				System.out.println("primeiro do deque X= " + teste.getX() + " Y= "+ teste.getY());
				Coordinate ultimo = (Coordinate) deque.getLast();
				System.out.println("ultimo X= " + ultimo.getX() + " Y=" + ultimo.getY());
				Coordinate penultimo = (Coordinate) deque.getPenultimate();
				double curva = (((ultimo.getX() - penultimo.getX())*(t1.getY()-penultimo.getY())) - ((ultimo.getX()-penultimo.getY())*(t1.getX()-penultimo.getX())));
				
				if(curva > 0) {//curva para esquerda
					deque.addLast(t1);
				}
				
				if(curva == 0) { //colineares
					if(t1.getY()> ultimo.getY() && t1.getY() > penultimo.getY()) {
						deque.removeLast();
						deque.removeLast();
						deque.addLast(t1);
					}
					if(t1.getY() > ultimo.getY() && t1.getY() < penultimo.getY()) {
						System.out.println("entrei");
						deque.removeLast();
					}
				}
				
				else {
					deque.removeLast();
					deque.addLast(t1);
				}
			}
			k++;
		}

		return  (List<Coordinate>) deque;
	}

	
	private void ordenarVetor(List<Coordinate> points, Coordinate P) {
		Collections.sort(points, new Comparator<Coordinate>() {

			// devolve -1 se c1 < c2, 1 se c1 > c2 ou 0 se c1 = c2
			@Override
			public int compare(Coordinate p1, Coordinate p2) {
				
				double anguloP1 = obterAngulo (p1, P);
				double anguloP2 = obterAngulo (p2, P);
				
				if (anguloP1 < anguloP2) {
					return -1;
				}

				if (anguloP1 > anguloP2) {
					return 1;
				}
				return 0;
			}
		});
	}
	
	public double obterAngulo (Coordinate p1, Coordinate P){
		//Coordinate aux = null;
		//aux.setX(p1.getX());
		//aux.setY(P.getY());
	
		double catetoAdj = 0;
		double catetoOpt = (double) (p1.getY() - P.getY());
		
		if(p1 == P) return 0;
		
		int quadrante = obterQuadrante(p1, P);
		
		if (quadrante == 0) return 90;
		
		if(quadrante == 1) {
			catetoAdj = (double) (p1.getX() - P.getX());
			double tan = catetoOpt/catetoAdj;
			
			//depois de achar a tangente, calcula a arctan e devolve em graus
			double angulo = Math.toDegrees(Math.atan(tan));
			
			return angulo;
		}
		
		else //quadrante == 2
			catetoAdj = (double) (P.getX() - p1.getX());
		
			double tan = catetoOpt/catetoAdj;
		
			//depois de achar a tangente, calcula a arctan e devolve em graus
			double angulo = Math.toDegrees(Math.atan(tan));
		
			return angulo+90; //90 eh o incremento por estar do lado esquerdo
					
	}
	
	
	//o ponto P vai ser a origem
	// sendo assim, nao importa a altura (Y) que o ponto esta, sempre iremos tratar como esta a direita ou a esquerda
	//desta maneira, so teremos dois quadrantes
		// no primeiro quadrante sao aqueles que possuem X positivo
		// no segundo quadrante sao aqueles que possuem X negativo 
	public int obterQuadrante (Coordinate p1, Coordinate P) {
		if(p1.getX()> P.getX()) return 1; //direita
		if(p1.getX() == P.getX()) return 0; // colineares
		else return 2; // esquerda
	}
}

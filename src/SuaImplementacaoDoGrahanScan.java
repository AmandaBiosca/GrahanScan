import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuaImplementacaoDoGrahanScan implements ConvexHullSolver {

	@Override
	public List<Coordinate> findConvexHull(List<Coordinate> points) {
		// TODO Auto-generated method stub
		
		//if(points == null) throw new Exception();
		
		//procurar como achar esse ponto P com menor Y
		Coordinate P = null;
		for(Coordinate p2 : points) {
			if(p2.getY() < P.getY()) P = p2; //nao seria <?
		}
		
		//ordenar o vetor pelo angulo que os pontos fazem com o ponto P em relacao ao eixo X
		ordenarVetor (points, P);
		
		List<Coordinate> deque = (List<Coordinate>) new LinkedListDeque();
		//odernar o vetor points, e ir caminhando com ele e inseridno no deque
		//eu primeiro comparo o ponto atual que estou antes de inserir no deque
		//se juntando o angulo do atual que eu tenho mais o penultimo do deque fizer uma curva para a direita
			//entao eu excluo o ultimo e insiro o atual
			// se a curva for para a esquerda eu somente insiro
			//se for igual a 0, quer dizer que sao colineares, entao nao faco nada
		
		
		return null;
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
		Coordinate aux = null;
		aux.setX(p1.getX());
		aux.setY(P.getY());
	
		double catetoAdj = 0;
		double catetoOpt = (double) (p1.getY() - aux.getY());
		int quadrante = obterQuadrante(p1, P);
		
		if (quadrante == 0) return 90;
		
		if(quadrante == 1) {
			catetoAdj = (double) (aux.getX() - P.getX());
			double tan = catetoOpt/catetoAdj;
			
			//depois de achar a tangente, calcula a arctan e devolve em graus
			double angulo = Math.toDegrees(Math.atan(tan));
			
			return angulo;
		}
		
		else //quadrante == 2
			catetoAdj = (double) (P.getX() - aux.getX());
		
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

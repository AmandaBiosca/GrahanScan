import java.util.List;

public class SuaImplementacaoDoGrahanScan implements ConvexHullSolver {

	@Override
	public List<Coordinate> findConvexHull(List<Coordinate> points) {
		// TODO Auto-generated method stub
		
		//if(points == null) throw new Exception();
		
		//procurar como achar esse ponto P com menor Y
		Coordinate P = null;
		for(Coordinate p2 : points) {
			if(p2.getY() > P.getY()) P = p2; //nao seria <?
		}
		
		//ordenar o vetor pelo angulo que os pontos fazem com o ponto P em relacao ao eixo X
		//odernar o vetor points, e ir caminhando com ele e inseridno no deque
		//eu primeiro comparo o ponto atual que estou antes de inserir no deque
		//se juntando o angulo do atual que eu tenho mais o penultimo do deque fizer uma curva para a direita
			//entao eu excluo o ultimo e insiro o atual
			// se a curva for para a esquerda eu somente insiro
			//se for igual a 0, quer dizer que sao colineares, entao nao faco nada
		
		
		return null;
	}

}

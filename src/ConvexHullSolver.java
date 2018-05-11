

import java.util.List;

public interface ConvexHullSolver {

	/**
	 * Recebe uma lista de pontos, contendo pelo menos 3 pontos nao colineares,
	 * e devolve uma lista contendo apenas os pontos que pertencem ao fecho
	 * convexo dos pontos dados na entrada
	 * 
	 * Sua tarefa eh implementar o algoritmo "Grahan Scan", conforme descricao em
	 * https://en.wikipedia.org/wiki/Graham_scan
	 */
	public List<Coordinate> findConvexHull(List<Coordinate> points);
}

package task1area;

public class App {

	
	public static void main(String[] args) {
		AreaQuadrilateral areaQuad = new RectArea();
		areaQuad.areaQuad();
		areaQuad = new SquareArea();
		areaQuad.areaQuad();
		areaQuad = new TrapeziumArea();
		areaQuad.areaQuad();
	}
}

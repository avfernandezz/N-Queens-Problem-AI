
/*				RECORRIDO DE ARBOL 4X4
 * 						RAIZ
 * 		C0				C1			C2 			C3
 *  C2		C3			C3			C0		 C0		C1	
 * 			  C1		C0			C3	   C2	
 * 						C2			C1
 * 					  SOLUCION   SOLUCION
 * 
 * EL CODIGO RECORRE TODO EL ARBOL HACIENDO UNA BUSQUEDA EN ANCHURA
 * */


public class NodoAnchura {
	static int numQueens;
	private int column;
	private int row;
	private NodoAnchura parentNode;
	private NodoAnchura aboveQueen;
		
	
	public NodoAnchura(int column, int row, NodoAnchura parentNode){
		this.column = column;
		this.row	= row;
		this.parentNode = parentNode;		
    }
	
	public void dekuTree(){
		if(row == numQueens){
			
			printSolution(this); 
//			System.exit(0); End on first response
            return;
		}
		printTree(this); //recorrido paso a paso
		for (int c = 0; c < numQueens; c++)
        {			
            aboveQueen = this;
            while (aboveQueen.column >= 0 && c != aboveQueen.column // vertical threat
                    && c - aboveQueen.column != row + 1 - aboveQueen.row // left diagonal
                    && aboveQueen.column - c != row + 1 - aboveQueen.row) // diagonal right
                aboveQueen = aboveQueen.parentNode; // check all of the above queens
            if (aboveQueen.row == 0){ // No threat founded
                new NodoAnchura(c , row + 1 , this).dekuTree(); // place the queen in the next row
            }
        }
	}
		
	private void printTree(NodoAnchura n){
		
		while (n.column >= 0)
        {
            System.out.print(n.column);
            n = n.parentNode;
        }
        System.out.println();
	}
	
	private void printSolution(NodoAnchura nodo){    
		System.out.print("Solución: ");
		while (nodo.column >= 0)
        {
            System.out.print(nodo.column);
            nodo = nodo.parentNode;
        }
        System.out.println();
    }
}

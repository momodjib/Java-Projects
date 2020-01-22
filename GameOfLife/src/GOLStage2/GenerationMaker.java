package GOLStage2;

public class GenerationMaker {
    private static String[][] presentGeneration;
    private static String[][] nextGeneration;


    public String[][] nextGeneration(String[][] generation){

       presentGeneration = generation;
       int size = presentGeneration.length;
       nextGeneration = new String[size][size];

       for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {

               if(i == 0){

               }else if(i == size-1){

               }else{
                   if (j == 0) {

                   }
                   else if (j == size-1){

                   }
                   else{
                       int aliveCells = checkNeighbours(i,j);
                       if (isAlive(i,j)){
                           if ((aliveCells >=2) && (aliveCells <=3)){
                               nextGeneration[i][j] = presentGeneration[i][j];
                           }else{
                               nextGeneration[i][j] = " ";
                           }
                       }
                       else{
                           if (aliveCells == 3){
                               nextGeneration[i][j] = "O";
                           }else{
                               nextGeneration[i][j] = presentGeneration[i][j];
                           }
                       }
                   }
               }
           }
       }
       return nextGeneration;
    }

   public int checkNeighbours(int row, int col){
       int aliveNeighbours = 0;

       if (isAlive(row-1,col-1)){
           aliveNeighbours++;
       }
        if (isAlive(row-1,col)){
            aliveNeighbours++;
        }
        if (isAlive(row-1,col+1)){
            aliveNeighbours++;
        }

        if (isAlive(row,col-1)){
            aliveNeighbours++;
        }
        if (isAlive(row,col+1)){
            aliveNeighbours++;
        }

        if (isAlive(row+1,col-1)){
            aliveNeighbours++;
        }
       if (isAlive(row+1,col)){
           aliveNeighbours++;
       }
       if (isAlive(row-1,col+1)){
           aliveNeighbours++;
       }

       return aliveNeighbours;
    }

   public boolean isAlive(int row, int col){
       return presentGeneration[row][col].equals("O");
    }

}

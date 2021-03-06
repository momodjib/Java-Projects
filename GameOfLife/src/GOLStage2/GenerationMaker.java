package GOLStage2;

public class GenerationMaker {
    private static String[][] currentGeneration;
    private static String[][] nextGeneration;
    private static int aliveNeighbours;


    public String[][] nextGeneration(String[][] generation){

       currentGeneration = generation;
       int size = currentGeneration.length;
       nextGeneration = new String[size][size];

       for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {

               if(i == 0){
                   setNextGeneration(checkTopNeighbours(i,j),i,j);

               }else if(i == size-1){
                   setNextGeneration(checkBottomNeighbours(i,j),i,j);

               }else{
                   if (j == 0) {
                        setNextGeneration(checkLeftNeighbours(i,j),i,j);
                   }
                   else if (j == size-1){
                       setNextGeneration(checkRightNeighbours(i,j),i,j);
                   }
                   else{
                       setNextGeneration(checkNeighbours(i,j),i,j);
                   }
               }
           }
       }
       return nextGeneration;
    }

    public int checkNeighbours(int row, int col){
        aliveNeighbours = 0;

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
       if (isAlive(row+1,col+1)){
           aliveNeighbours++;
       }

       return aliveNeighbours;
    }

    public int checkTopNeighbours(int row, int col){
        aliveNeighbours = 0;

        if (col == 0) {
            //top neighbours
            if (isAlive(currentGeneration.length-1,currentGeneration.length-1)){
                aliveNeighbours++;
            }
            if (isAlive(currentGeneration.length-1,col)){
                aliveNeighbours++;
            }
            if (isAlive(currentGeneration.length-1,col+1)){
                aliveNeighbours++;
            }

            //direct neighbours
            if (isAlive(row,currentGeneration.length-1)){
                aliveNeighbours++;
            }
            if (isAlive(row,col+1)){
                aliveNeighbours++;
            }

            //bottom neighbours
            if (isAlive(row+1,currentGeneration.length-1)){
                aliveNeighbours++;
            }
            if (isAlive(row+1,col)){
                aliveNeighbours++;
            }
            if (isAlive(row+1,col+1)){
                aliveNeighbours++;
            }
        }
        else if (col == currentGeneration.length-1){

            //top neighbours
            if (isAlive(currentGeneration.length-1,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(currentGeneration.length-1,col)){
                aliveNeighbours++;
            }
            if (isAlive(currentGeneration.length-1,0)){
                aliveNeighbours++;
            }

            //direct neighbours
            if (isAlive(row,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row,0)){
                aliveNeighbours++;
            }

            //bottom neighbours
            if (isAlive(row+1,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row+1,col)){
                aliveNeighbours++;
            }
            if (isAlive(row+1,0)){
                aliveNeighbours++;
            }
        }
        else{
            //top neighbours
            if (isAlive(currentGeneration.length-1,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(currentGeneration.length-1,col)){
                aliveNeighbours++;
            }
            if (isAlive(currentGeneration.length-1,col+1)){
                aliveNeighbours++;
            }

            //direct neighbours
            if (isAlive(row,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row,col+1)){
                aliveNeighbours++;
            }

            //bottom neighbours
            if (isAlive(row+1,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row+1,col)){
                aliveNeighbours++;
            }
            if (isAlive(row+1,col+1)){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    public int checkBottomNeighbours(int row, int col){
        aliveNeighbours = 0;

        if (col == 0) {
            //top neighbours
            if (isAlive(row-1,currentGeneration.length-1)){
                aliveNeighbours++;
            }
            if (isAlive(row-1,col)){
                aliveNeighbours++;
            }
            if (isAlive(row-1,col+1)){
                aliveNeighbours++;
            }

            //direct neighbours
            if (isAlive(row,currentGeneration.length-1)){
                aliveNeighbours++;
            }
            if (isAlive(row,col+1)){
                aliveNeighbours++;
            }

            //bottom neighbours
            if (isAlive(0,currentGeneration.length-1)){
                aliveNeighbours++;
            }
            if (isAlive(0,col)){
                aliveNeighbours++;
            }
            if (isAlive(0,col+1)){
                aliveNeighbours++;
            }
        }
        else if (col == currentGeneration.length-1){

            //top neighbours
            if (isAlive(row-1,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row-1,col)){
                aliveNeighbours++;
            }
            if (isAlive(row-1,0)){
                aliveNeighbours++;
            }

            //direct neighbours
            if (isAlive(row,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row,0)){
                aliveNeighbours++;
            }

            //bottom neighbours
            if (isAlive(0,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(0,col)){
                aliveNeighbours++;
            }
            if (isAlive(0,0)){
                aliveNeighbours++;
            }
        }
        else{
            //top neighbours
            if (isAlive(row-1,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row-1,col)){
                aliveNeighbours++;
            }
            if (isAlive(row-1,col+1)){
                aliveNeighbours++;
            }

            //direct neighbours
            if (isAlive(row,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(row,col+1)){
                aliveNeighbours++;
            }

            //bottom neighbours
            if (isAlive(0,col-1)){
                aliveNeighbours++;
            }
            if (isAlive(0,col)){
                aliveNeighbours++;
            }
            if (isAlive(0,col+1)){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    public int checkLeftNeighbours(int row, int col){
        aliveNeighbours = 0;

        if (isAlive(row-1,currentGeneration.length-1)){
            aliveNeighbours++;
        }
        if (isAlive(row-1,col)){
            aliveNeighbours++;
        }
        if (isAlive(row-1,col+1)){
            aliveNeighbours++;
        }

        if (isAlive(row,currentGeneration.length-1)){
            aliveNeighbours++;
        }
        if (isAlive(row,col+1)){
            aliveNeighbours++;
        }

        if (isAlive(row+1,currentGeneration.length-1)){
            aliveNeighbours++;
        }
        if (isAlive(row+1,col)){
            aliveNeighbours++;
        }
        if (isAlive(row+1,col+1)){
            aliveNeighbours++;
        }

        return aliveNeighbours;
    }

    public int checkRightNeighbours(int row,int col){
        aliveNeighbours = 0;

        if (isAlive(row-1,col-1)){
            aliveNeighbours++;
        }
        if (isAlive(row-1,col)){
            aliveNeighbours++;
        }
        if (isAlive(row-1,0)){
            aliveNeighbours++;
        }

        if (isAlive(row,col-1)){
            aliveNeighbours++;
        }
        if (isAlive(row,0)){
            aliveNeighbours++;
        }

        if (isAlive(row+1,col-1)){
            aliveNeighbours++;
        }
        if (isAlive(row+1,col)){
            aliveNeighbours++;
        }
        if (isAlive(row+1,0)){
            aliveNeighbours++;
        }

        return aliveNeighbours;
    }

    public void setNextGeneration(int aliveCells, int row, int col){

        if (isAlive(row,col)){
            if ((aliveCells == 2) || (aliveCells == 3)){
                nextGeneration[row][col] = "O";
            }else{
                nextGeneration[row][col] = " ";
            }
        }
        else{
            if (aliveCells == 3){
                nextGeneration[row][col] = "O";
            }else{
                nextGeneration[row][col] = " ";
            }
        }
    }

    public boolean isAlive(int row, int col){
       return currentGeneration[row][col].equals("O");
    }

}

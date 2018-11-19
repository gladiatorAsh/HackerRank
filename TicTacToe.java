
public class TicTacToe {
    public class Player{
        public String name;
        public Character symbol;
        Player(String name, Character symbol){
            this.name=name;
            this.symbol=symbol;
        }
    }

    char[][] board;
    int movesPresent;

    Player player1;
    Player player2;

    public TicTacToe(){
        board=new char[3][3];
        movesPresent=9;
        player1=new Player("Player1",'X');
        player1=new Player("Player2",'O');
        resetBoard();
    }

    private boolean isSymbolAllowed(char symbol){
        char[] symbols={'X','O'};
        for (int i=0;i<symbols.length;i++){
            if(symbols[i]==symbol){
                return true;
            }
        }
        return false;
    }

    private boolean resetBoard(){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }

        movesPresent=9;
        return true;
    }

    private void printBoard(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private boolean updateBoard(int row, int col, char symbol){
        if(row<0||row>=3||col<0||col>=3||board[row][col]!=' '||movesPresent<=0){
            return false;
        }
        board[row][col]=symbol;
        movesPresent--;

        checkBoard();

        if(movesPresent<=0){
            System.out.println("Game's over");
            System.out.println("Resetting the board");
            resetBoard();
        }

        return true;
    }

    private void checkBoard() {

        if(board[0][0]== board[0][1] && board[0][1] ==board[0][2]){
            if(board[0][0]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[0][0]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }


        }
        if(board[1][0]==board[1][1]&& board[1][1]==board[1][2]){
            if(board[1][0]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[1][0]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
        if(board[2][0]==board[2][1]&& board[2][1]==board[2][2]){
            if(board[2][0]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[2][0]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
        if(board[0][0]==board[1][0]&&board[1][0]==board[2][0]){
            if(board[0][0]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[0][0]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
        if(board[0][1]==board[1][1]&&board[1][1]==board[2][1]){
            if(board[0][1]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[0][1]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
        if(board[0][2]==board[1][2]&&board[1][2]==board[2][2]){
            if(board[0][2]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[0][2]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
            if(board[0][0]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[0][0]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
            if(board[0][2]=='X'){
                System.out.println("Player 1 wins");
                resetBoard();
            }
            else if(board[0][2]=='O'){
                System.out.println("Player 2 wins");
                resetBoard();
            }
        }
    }

    public static void main(String[] args){
        TicTacToe game=new TicTacToe();
        game.updateBoard(0,0,'X');
        game.updateBoard(1,1,'O');

        game.updateBoard(2,2,'X');
        game.updateBoard(2,0,'O');

        game.updateBoard(0,2,'X');
        game.printBoard();

        game.updateBoard(1,2,'O');
        game.printBoard();
        game.updateBoard(0,1,'X');
        
    }

}


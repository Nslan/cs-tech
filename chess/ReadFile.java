package chess;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile {
    private String file;
    private ArrayList<ArrayList<String>> readFile = new ArrayList<ArrayList<String>>();
    private int[][] board;
    public ReadFile(String file, int[][] board) {
        this.file = file;
        this.board = board;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void readTextBoard(){

        try {

            Scanner input = new Scanner( new File( this.file ) );

            while(input.hasNextLine())
            {
                Scanner colReader = new Scanner(input.nextLine());
                ArrayList col = new ArrayList();
                while(colReader.hasNextLine())
                {
                    col.add(colReader.next());
                }
                this.readFile.add(col);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void printTextBoard(){

        for ( int i=0; i< readFile.size(); i++  ) {

            for (int j = 0; j < readFile.get(i).size(); j++) {

                 String s = this.readFile.get(i).get(j);

                System.out.print(s+"\t");

            }
            System.out.println("");
        }
    }

    public void makeMatrixBoard(){
        // always must 8 x 8
        for ( int i=0; i<this.readFile.size(); i++  ) {

            for (int j=0; j < this.readFile.get(i).size(); j++  ) {

                if ( readFile.get(i).get(j) !=  " " ){

                    char character = this.readFile.get(i).get(j).charAt(0); // 1. karakter tasın ne oldugunu
                    char  color = this.readFile.get(i).get(j).charAt(1); // 2. karakter ise rengini verir

                    if ( color == 'b' ){ //beyaz taslar matriste - degere sahip olsun

                        switch ( character ){

                            case 'p' : this.board[i][j] = -1 ; break;
                            case 'f' : this.board[i][j] = -2 ; break;
                            case 'a' : this.board[i][j] = -3 ; break;
                            case 'k' : this.board[i][j] = -4 ; break;
                            case 'v' : this.board[i][j] = -5 ; break;
                            case 's' : this.board[i][j] = -6 ; break;

                        }

                    }
                    if( color == 's' ) { //siyah taslar matriste - degere sahip olsun

                        switch ( character ){

                            case 'p' : this.board[i][j] = 1 ; break;
                            case 'f' : this.board[i][j] = 2 ; break;
                            case 'a' : this.board[i][j] = 3 ; break;
                            case 'k' : this.board[i][j] = 4 ; break;
                            case 'v' : this.board[i][j] = 5 ; break;
                            case 's' : this.board[i][j] = 6 ; break;
                        }

                    }

                    if ( this.readFile.get(i).get(j).equals("--") ){//-- boardda bos alanları temsil eder
                        this.board[i][j] = 0 ;
                    }

                }
            }
        }
    }

    public void printMatrixBoard(){
        for ( int i=0; i< readFile.size(); i++  ) {
            for (int j = 0; j < readFile.get(i).size(); j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println("");

        }
    }


}


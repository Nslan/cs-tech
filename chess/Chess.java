package chess;

public class Chess {
    private final double pawn = 1;//piyon
    private final double bishop = 3; // fil
    private final double knight = 3; // at
    private final double rook = 5; // kale
    private final double vizier = 9; //vezir
    private final double king = 100;//sah
    private static int[][] board = new int[8][8];

    public void start(){

        ReadFile[] r = new ReadFile[3];
        r[0] = new ReadFile("src/chess/board1.txt",board);
        r[1] = new ReadFile("src/chess/board2.txt",board);
        r[2] = new ReadFile("src/chess/board3.txt",board);

        System.out.println("\n  Tahta Dosya Adi \t \tSonuclar");
        System.out.println("------------------------------------------------");
        for ( ReadFile in : r ) {
            in.readTextBoard();
            in.makeMatrixBoard();
            System.out.print( in.getFile() + "  ");
            CheckStone();

            //in.printTextBoard();
            //in.printMatrixBoard();
        }


    }
    private   void CheckStone(){
        double sumB = 0; double sumW = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int count=0; // her eleman için yani her indis için yeniden 0 lanır

                if ( board[i][j] > 0  ){ // + sayilar siyah

                    if ( board[i][j] == 1 ){ /* o lokasyondaki eleman piyon ise

                        // bu 3 durumdan herhangi birinden veya hepsinden en az 1 tane tehdit donerse piyon degeri yarısına duser
                        // hiçbir şekilde tehdit donmezse piyon degeri aynı kalır
                        //ayrıca herbir piyonun degeri ayrı olarak tutulabilmeli
                        //tehdit piyon mu ?
                        //tehdit at mı
                        //tehdit vezir mi?
                        //herhangi birinden bir tehdit varsa*/

                        if( checkPawn(i,j , "black") || checkKnight(i,j , "black")  || checkVizier(i, j , "black")) {
                            count++;
                        }

                        if (count>0) {
                            sumB += pawn / 2 ;
                        }
                        if ( count == 0) sumB += pawn ;

                        //System.out.println(""+ board[i][j]  + "  Piyon  sumB : " + sumB);
                    }
                    if ( board[i][j] == 2 ){// eleman fil

                        if( checkPawn(i,j,"black") || checkKnight(i,j,"black")  || checkVizier(i, j,"black")) {
                            count++;
                        }

                        if (count>0) {
                            sumB += bishop / 2 ;
                        }
                        if ( count == 0) sumB += bishop ;

                        //System.out.println(" "+ board[i][j]  + "  fil  sumB : " + sumB);

                    }
                    if ( board[i][j] == 3 ){// eleman at

                        if( checkPawn(i,j , "black") || checkKnight(i,j , "black")  || checkVizier(i, j , "black")) {
                            count++;
                        }

                        if (count>0) {
                            sumB += knight / 2 ;
                        }
                        if ( count == 0) sumB += knight ;

                        //System.out.println(" "+ board[i][j]  + "  At  sumB : " + sumB);
                    }
                    if ( board[i][j] == 4 ){// eleman kale

                        if( checkPawn(i,j , "black") || checkKnight(i,j , "black")  || checkVizier(i, j , "black")) {
                            count++;
                        }

                        if (count>0) {
                            sumB += rook / 2 ;
                        }
                        if ( count == 0) sumB += rook ;

                        //System.out.println(" "+ board[i][j]  + "  Kale  sumB : " + sumB);
                    }
                    if ( board[i][j] == 5 ){ // eleman vezir
                        if( checkPawn(i,j , "black") || checkKnight(i,j , "black")  || checkVizier(i, j , "black")) {
                            count++;
                        }

                        if (count>0) {
                            sumB += vizier / 2 ;
                        }
                        if ( count == 0) sumB += vizier ;

                        //System.out.println(" "+ board[i][j]  + "  Vezir  sumB : " + sumB);
                    }
                    if ( board[i][j] == 6 ){ // eleman sah ise

                        if( checkPawn(i,j , "black") || checkKnight(i,j , "black")  || checkVizier(i, j , "black")) {
                            count++;
                        }

                        if (count>0) {
                            sumB += king / 2 ;
                        }
                        if ( count == 0) sumB += king ;

                        //System.out.println(" "+ board[i][j]  + "  Sah  sumB : " + sumB);
                    }
                }
                if ( board[i][j] < 0 ){//beyaz

                    if ( board[i][j] == -1 ){ // o lokasyondaki eleman piyon ise


                        if( checkPawn(i,j , "white") || checkKnight(i,j , "white")  || checkVizier(i, j , "white")) {
                            count++;
                        }

                        if (count>0) {
                            sumW += pawn / 2 ;
                        }
                        if ( count == 0) sumW += pawn ;


                    }
                    if ( board[i][j] == -2 ){// eleman fil

                        if( checkPawn(i,j,"white") || checkKnight(i,j,"white")  || checkVizier(i, j,"white")) {
                            count++;
                        }

                        if (count>0) {
                            sumW += bishop / 2 ;
                        }
                        if ( count == 0) sumW += bishop ;


                    }
                    if ( board[i][j] == -3 ){// eleman at

                        if( checkPawn(i,j , "white") || checkKnight(i,j , "white")  || checkVizier(i, j , "white")) {
                            count++;
                        }

                        if (count>0) {
                            sumW += knight / 2 ;
                        }
                        if ( count == 0) sumW += knight ;


                    }
                    if ( board[i][j] == -4 ){// eleman kale

                        if( checkPawn(i,j , "white") || checkKnight(i,j , "white")  || checkVizier(i, j , "white")) {
                            count++;
                        }

                        if (count>0) {
                            sumW += rook / 2 ;
                        }
                        if ( count == 0) sumW += rook ;


                    }
                    if ( board[i][j] == -5 ){ // eleman vezir
                        if( checkPawn(i,j , "white") || checkKnight(i,j , "white")  || checkVizier(i, j , "white")) {
                            count++;
                        }

                        if (count>0) {
                            sumW += vizier / 2 ;
                        }
                        if ( count == 0) sumW += vizier ;


                    }
                    if ( board[i][j] == -6 ){ // eleman sah ise

                        if( checkPawn(i,j , "white") || checkKnight(i,j , "white")  || checkVizier(i, j , "white")) {
                            count++;
                        }

                        if (count>0) {
                            sumW += king / 2 ;
                        }
                        if ( count == 0) sumW += king ;

                    }


                }
            }

        }
        System.out.println("Siyah:"+sumB+"\tBeyaz:"+sumW);
    }

    //vezir at ve piyon tarafından olan tehditler tehdit altında puanlar yarıya duser

    private boolean checkPawn(int i, int j , String color ){
        //System.out.println("piyon kontrol => yeni deger : " + i + "-" + j + " : "+ board[i][j] );

        if ( color == "black"){
                // sol alt capraz || sağ alt capraz
            if ( ( i+1<8 && j-1>0 && board[i+1][j-1] == -1 ) || ( i+1<8 && j+1<8 && board[i+1][j+1] == -1 )){
                return true;
            }

        }

        if (color == "white"){
                    // sol ust capraz || sağ ust capraz
            if ( ( i-1>0 && j-1>0 && board[i-1][j-1] == 1 ) || ( i-1>0 && j+1<8 && board[i-1][j+1] == 1 )){
                return true;
            }

        }
        return false;
    }

    private boolean checkKnight(int i, int j , String color){
        //System.out.println("at kontrol    => yeni deger : " + i + "-" + j + " : "+ board[i][j] );

        if (color == "black"){

            if ((i + 2 < 8 && j + 1 < 8 && board[i + 2][j + 1] == -3) || (i + 2 < 8 && j - 1 >= 0 && board[i + 2][j - 1] == -3)
                    || (i - 2 >= 0 && j + 1 < 8 && board[i - 2][j + 1] == -3) || (i - 2 >= 0 && j - 1 >= 0 && board[i - 2][j - 1] == -3)
                    || (i - 1 >= 0 && j + 2 < 8 && board[i - 1][j + 2] == -3) || (i + 1 < 8 && j + 2 < 8 && board[i + 1][j + 2] == -3)
                    || (i - 1 >= 0 && j - 2 >= 0 && board[i - 1][j - 2] == -3) || (i + 1 < 8 && j - 2 >= 0 && board[i + 1][j - 2] == -3)){

                return true;

            }
        }

        if (color == "white"){

            if ((i + 2 < 8 && j + 1 < 8 && board[i + 2][j + 1] == 3) || (i + 2 < 8 && j - 1 >= 0 && board[i + 2][j - 1] == 3)
                    || (i - 2 >= 0 && j + 1 < 8 && board[i - 2][j + 1] == 3) || (i - 2 >= 0 && j - 1 >= 0 && board[i - 2][j - 1] == 3)
                    || (i - 1 >= 0 && j + 2 < 8 && board[i - 1][j + 2] == 3) || (i + 1 < 8 && j + 2 < 8 && board[i + 1][j + 2] == 3)
                    || (i - 1 >= 0 && j - 2 >= 0 && board[i - 1][j - 2] == 3) || (i + 1 < 8 && j - 2 >= 0 && board[i + 1][j - 2] == 3)){

                return true;

            }
        }

        return false;
    }

    private boolean checkVizier(int i, int j , String color ){
       // System.out.println("vezir kontrol => yeni deger : " + i + "-" + j + " : "+ board[i][j] );

      if (color == "black"){

          //sag ust capraz || sol ust capraz || sağ alt capraz || sol alt capraz || yukarı taraf || asagı taraf || sag taraf || sol taraf
          if ( ( i - 1 >= 0 && j + 1 < 8 && board[i - 1][j + 1]  == -5) || ( i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == -5 )
                  || (i + 1 < 8 && j + 1 < 8 && board[i + 1][j + 1] == -5) || ( i + 1 < 8 && j - 1 >= 0 && board[i + 1][j - 1] == -5)
                  || ( i - 1 >= 0 && board[i - 1][j] == -5) || ( i + 1 < 8 && board[i + 1][j] == -5 )
                  || ( j + 1 < 8 && board[i][j + 1] == -5 ) || ( j - 1  >= 0 && board[i][j-1] == -5 ) ){

              return true;
          }

          //sag ust capraz : i azalırken j artar
           if ( i - 1 >= 0 && j + 1 < 8 && board[i - 1][j + 1]  == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i-a >=0 && j+a < 8 && board[i-a][j+a] != -5 && board[i-a][j+a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i-a >=0 && j+a < 8 && board[i-a][j+a] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          //sol ust capraz : i , j azalır
           if( i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 0 ) {

              for (int a = 1; a < 8 ; a++) {

                  if( i-a >=0 && j-a >=0 && board[i-a][j-a] != -5 && board[i-a][j-a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i-a >=0 && j-a >=0 && board[i-a][j-a] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          //sağ alt capraz : i , j artar
           if (i + 1 < 8 && j + 1 < 8 && board[i + 1][j + 1] == 0){

              for (int a = 1; a < 8  ; a++) {

                  if( i+a<8 && j+a< 8 && board[i+a][j+a] != -5 && board[i+a][j+a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i+a<8 && j+a< 8 && board[i+a][j+a] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          //sol alt capraz : i artarken j azalır
           if ( i + 1 < 8 && j - 1 >= 0 && board[i + 1][j - 1] == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i+a <8 && j-a >=0 &&  board[i+a][j-a] != -5 && board[i+a][j-a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if (  i+a <8 && j-a >=0 && board[i+a][j-a] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          // yukarı taraf : i azalır j sabit
           if ( i - 1 >= 0 && board[i - 1][j] == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i-a >= 0 && board[i-a][j] != -5 && board[i-a][j] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i-a >= 0 && board[i-a][j] == -5 ){ //eleman vezir ise
                      return true;
                  }

              }

          }

          // asagı taraf : i artar , j sabit
           if ( i + 1 < 8 && board[i + 1][j] == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i+a<8 && board[i+a][j] != -5 && board[i+a][j] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i+a<8 && board[i+a][j] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          // sag taraf : i sabit , j artar
           if ( j + 1 < 8 && board[i][j + 1] == 0 ){

              for (int a = 1; a < 8 ; a++) {

                  if( j+a< 8 && board[i][j+a] != -5 && board[i][j+a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( j+a<8 && board[i][j+a] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          // sol taraf : i sabit , j azalır
           if ( j - 1  >= 0 && board[i][j-1] == 0){

              for (int a = 1; a <8 ; a++) {

                  if( j-a>=0 && board[i][j-a] != -5 && board[i][j-a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( j-a>=0 && board[i][j-a] == -5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

      }

      if (color == "white"){

          //sag ust capraz || sol ust capraz || sağ alt capraz || sol alt capraz || yukarı taraf || asagı taraf || sag taraf || sol taraf
          if ( ( i - 1 >= 0 && j + 1 < 8 && board[i - 1][j + 1]  == 5) || ( i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 5 )
                  || (i + 1 < 8 && j + 1 < 8 && board[i + 1][j + 1] == 5) || ( i + 1 < 8 && j - 1 >= 0 && board[i + 1][j - 1] == 5)
                  || ( i - 1 >= 0 && board[i - 1][j] == 5) || ( i + 1 < 8 && board[i + 1][j] == 5 )
                  || ( j + 1 < 8 && board[i][j + 1] == 5 ) || ( j - 1  >= 0 && board[i][j-1] == 5 ) ){

              return true;
          }

          //sag ust capraz : i azalırken j artar
           if ( i - 1 >= 0 && j + 1 < 8 && board[i - 1][j + 1]  == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i-a >=0 && j+a < 8 && board[i-a][j+a] != 5 && board[i-a][j+a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i-a >=0 && j+a < 8 && board[i-a][j+a] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          //sol ust capraz : i , j azalır
           if( i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 0 ) {

              for (int a = 1; a < 8 ; a++) {

                  if( i-a >=0 && j-a >=0 && board[i-a][j-a] != 5 && board[i-a][j-a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i-a >=0 && j-a >=0 && board[i-a][j-a] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          //sağ alt capraz : i , j artar
           if (i + 1 < 8 && j + 1 < 8 && board[i + 1][j + 1] == 0){

              for (int a = 1; a < 8  ; a++) {

                  if( i+a<8 && j+a< 8 && board[i+a][j+a] != 5 && board[i+a][j+a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i+a<8 && j+a< 8 && board[i+a][j+a] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          //sol alt capraz : i artarken j azalır
           if ( i + 1 < 8 && j - 1 >= 0 && board[i + 1][j - 1] == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i+a <8 && j-a >=0 &&  board[i+a][j-a] != 5 && board[i+a][j-a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if (  i+a <8 && j-a >=0 && board[i+a][j-a] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          // yukarı taraf : i azalır j sabit
           if ( i - 1 >= 0 && board[i - 1][j] == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i-a >= 0 && board[i-a][j] != 5 && board[i-a][j] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i-a >= 0 && board[i-a][j] == 5 ){ //eleman vezir ise
                      return true;
                  }

              }

          }

          // asagı taraf : i artar , j sabit
           if ( i + 1 < 8 && board[i + 1][j] == 0){

              for (int a = 1; a < 8 ; a++) {

                  if( i+a<8 && board[i+a][j] != 5 && board[i+a][j] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( i+a<8 && board[i+a][j] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          // sag taraf : i sabit , j artar
           if ( j + 1 < 8 && board[i][j + 1] == 0 ){

              for (int a = 1; a < 8 ; a++) {

                  if( j+a< 8 && board[i][j+a] != 5 && board[i][j+a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( j+a<8 && board[i][j+a] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

          // sol taraf : i sabit , j azalır
           if ( j - 1  >= 0 && board[i][j-1] == 0){

              for (int a = 1; a <8 ; a++) {

                  if( j-a>=0 && board[i][j-a] != 5 && board[i][j-a] != 0  ){ //eleman vezir veya bos degilse artık bakma
                      break;
                  }
                  if ( j-a>=0 && board[i][j-a] == 5 ){ //eleman vezir ise
                      return true;
                  }
              }

          }

      }

        return false;
    }

}

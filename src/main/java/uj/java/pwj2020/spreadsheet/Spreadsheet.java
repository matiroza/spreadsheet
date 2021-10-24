package uj.java.pwj2020.spreadsheet;

public class Spreadsheet {
    public static void main(String[] args){
        String[][] arkusz = {
                {"$C11","2","3"},
                {"$A3","2","3"},
                {"$A4","2","3"},
                {"$A5","2","3"},
                {"$A6","2","3"},
                {"$A7","2","3"},
                {"$A11","2","3"},
                {"$A11","2","3"},
                {"$A11","2","3"},
                {"$A11","2","3"},
                {"$A1","2","-10"}
        };

        printArkusz(arkusz);
        calculate(arkusz);
        printArkusz(arkusz);

    }

    public static void printArkusz(String[][] strings){
        for(String[] row : strings){
            for(String column : row){
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String[][] calculate(String[][] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (!isNumeric(input[i][j])) {
                    if (input[i][j].charAt(0) == '$') {
                        input[i][j] = referencja(input, input[i][j], i, j);
                        //System.out.print("$ ");
                    } else if (input[i][j].charAt(0) == '=') {
                        funckja(input, input[i][j], i, j);
                        //System.out.print("= ");
                    }
                }
            }
        }
        return input;
    }

    private static void funckja(String[][] input, String s, int i, int j) {
        // =ADD(10,$A1)
        String f = input[i][j].substring(1,4);
        String a = input[i][j].substring( input[i][j].indexOf('(') + 1, input[i][j].indexOf(',') ); //10
        String b = input[i][j].substring( input[i][j].indexOf(',') + 1, input[i][j].indexOf(')') ); //$A1

        if(!isNumeric( a )) { a = referencja(input, a, i, j) ;}

        if(!isNumeric( b )) { b = referencja(input, b, i, j) ;}

        switch (f){
            case "ADD" -> input[i][j] = String.valueOf( Integer.parseInt(a) + Integer.parseInt(b) );
            case "SUB" -> input[i][j] = String.valueOf( Integer.parseInt(a) - Integer.parseInt(b) );
            case "MUL" -> input[i][j] = String.valueOf( Integer.parseInt(a) * Integer.parseInt(b) );
            case "DIV" -> input[i][j] = String.valueOf( Integer.parseInt(a) / Integer.parseInt(b) );
            case "MOD" -> input[i][j] = String.valueOf( Integer.parseInt(a) % Integer.parseInt(b) );
        }

    }

    public static String referencja(String[][] input, String s, int i, int j){
        // np. $A1
        int[] coordinates = getCoordinates(s);
        String result = input[coordinates[0]][coordinates[1]];
        if(result.charAt(0) == '$'){
            result = referencja(input, result, i, j);
        }
        return result;
    }

    public static int[] getCoordinates(String s){
        int column = (int) s.charAt(1) - 65; //np. $A1
        String rowS = s.substring(2);
        int row = Integer.parseInt(rowS) - 1;
        return new int[] { row, column};
    }

    public static boolean isNumeric(String s) {
        if (s == null) { return false; }
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

}

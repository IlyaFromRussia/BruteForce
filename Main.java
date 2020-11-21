package com.company;
/*
 * author Lobov-IR
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        doBruteForce(3,2, 1);
    }
    // countOfVariants - count of variants which variable can accept. For example
    // for boolean variable count of variants is 2: true and false

    // countOfElements - count of elements who take part in brute force at the same time
    // For example for boolean variable and 2 elements table of brute force can be like it:
    //        0011
    //        0101

    // startWith - first value of variant. In example above startWith is 0

    public static void doBruteForce(int countOfElements, int countOfVariants, int startWith){

        ArrayList<ArrayList<Integer>> Table = new ArrayList<>();
        for(int i = 0 ; i<countOfElements; i++){
            Table.add(new ArrayList<>());
        }
        ArrayList<Integer> column = new ArrayList();
        for(int i = 0; i < countOfElements; i++){
            column.add(startWith);
        }

        int after;
        boolean isChanged = false;


        for(int i = 0; i< Math.pow(countOfVariants, countOfElements); i++){
            isChanged = false;
            if(i==0){
                for(int j = 0; j < column.size(); j++){
                    Table.get(j).add(column.get(j));
                }
                continue;
            }

            for(int j = column.size()-1; j>=0; j--){
                if(column.get(j)!=countOfVariants + startWith - 1 && !isChanged){
                    after = column.get(j)+1;
                    isChanged = true;
                    column.set(j,after);

                    if(j!=column.size() - 1){
                        for(int k = j+1; k < column.size(); k++){
                            column.set(k, startWith);
                        }
                    }
                    break;

                }
            }


            for(int j = 0; j < column.size(); j++){
                Table.get(j).add(column.get(j));
            }
        }
        // Print result of Brute force
        for(int i = 0; i < Table.size(); i++){
            for(int j = 0; j < Table.get(i).size(); j++){
                System.out.print(Table.get(i).get(j)+" ");
            }
            System.out.println("");
        }
    }
}

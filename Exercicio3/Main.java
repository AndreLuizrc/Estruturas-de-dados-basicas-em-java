package Exercicio3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        int[] vetB = {46,38,22,10};
        int[] vetA = {6,7,8};

        int[] vetC = vetorOrdenado(vetA, vetB);

        for(int i = 0; i < vetC.length; i++){
            System.out.println(vetC[i]);
        }
    }

    public static int[] vetorOrdenado(int[] vetA, int[] vetB){
        int tamVetC = vetA.length + vetB.length;
        int[] vetC = new int[tamVetC];
        int iA = 0, iB = 0;

        Arrays.sort(vetA);
        Arrays.sort(vetB);

        int[] vetAextend = new int[vetA.length + 1];
        int[] vetBextend = new int[vetB.length + 1];

        vetAextend[vetA.length] = Integer.MAX_VALUE;
        vetBextend[vetB.length] = Integer.MAX_VALUE;

        for(int i = 0; i < vetA.length; i++){
            vetAextend[i] = vetA[i];
        }

        for(int i = 0; i < vetB.length; i++){
            vetBextend[i] = vetB[i];
        }

        for(int i = 0; i < tamVetC; i++ ){
            if(vetAextend[iA] < vetBextend[iB]){
                vetC[i] = vetAextend[iA];
                iA++;
            }else {
                vetC[i] = vetBextend[iB];
                iB++;
            }
        }

        return vetC;
    }
}

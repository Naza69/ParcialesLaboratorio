package ProyectoLab.src;
//Programa de reclutamiento de mutantes de Magneto
//Parcial 2 Laboratorio
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Parcial2Lab {
    public static void main(String[] args){
        functions fn = new functions();
        fn.main_function();
    }
}

//Caso de prueba mutante
//String[] dna_sequence = {
//    "AAAACT",
//    "CATACT",
//    "GTTTTA",
//    "TATTGT",
//    "GCTGTA",
//    "CGTACA"             }
//System.out.println(is_mutant(dna_sequence))

//Caso de prueba no mutante
//String[] dna_sequence = {
//    "AACACT",
//    "CGTATC",
//    "GTAGCA",
//    "TATAGT",
//    "GCAGTA",
//    "CGTACA"             }
//System.out.println(is_mutant(dna_sequence))

class functions {
    public boolean is_mutant(ArrayList<String> dna) {                               //Metodo booleano para verificar 4 nucleotidos consecutivos en filas, columnas o diagonales
        String[] dna_array = new String[6];                                         //Y por tanto para saber si la secuencia de adn es de un mutante o no
        dna_array = dna.toArray(dna_array);
        int counter_mutations = 0;
        for (int row = 0; row < dna.size(); row++) {
            for (int column = 0; column < dna_array[row].length(); column++) {
                if (column < 3 && dna_array[row].charAt(column) == dna_array[row].charAt(column + 1) && dna_array[row].charAt(column + 1) == dna_array[row].charAt(column + 2) && dna_array[row].charAt(column + 2) == dna_array[row].charAt(column + 3)) {
                    counter_mutations += 1;
                }
            }
        }
        for (int row = 0; row < dna.size(); row++) {
            for (int column = 0; column < dna_array[row].length(); column++) {
                if (row < 3 && dna_array[row].charAt(column) == dna_array[row + 1].charAt(column) && dna_array[row + 1].charAt(column) == dna_array[row + 2].charAt(column) && dna_array[row + 2].charAt(column) == dna_array[row + 3].charAt(column)) {
                    counter_mutations += 1;
                }
            }
        }
        for (int row = 0; row < dna.size(); row++) {
            for (int column = 0; column < dna_array[row].length(); column++) {
                if (row < 3 && column < 3 && dna_array[row].charAt(column) == dna_array[row + 1].charAt(column+1) && dna_array[row + 1].charAt(column+1) == dna_array[row + 2].charAt(column+2) && dna_array[row + 2].charAt(column+2) == dna_array[row + 3].charAt(column+3)) {
                    counter_mutations += 1;
                }
            }
        }
        for (int row = 0; row < dna.size(); row++) {
            for (int column = 0; column < dna_array[row].length(); column++) {
                if (row <= 3 && column >= 3 && dna_array[row].charAt(column) == dna_array[row + 1].charAt(column-1) && dna_array[row + 1].charAt(column-1) == dna_array[row + 2].charAt(column-2) && dna_array[row + 2].charAt(column-2) == dna_array[row + 3].charAt(column-3)) {
                    counter_mutations += 1;
                }
            }
        }
        if(counter_mutations > 1){
            return true;
        } else return false;
    }
    public void main_function() {                                                           //Metodo main para ejecutar el programa en su conjunto
        Scanner sc = new Scanner(System.in);
        String choice="";
        while (true) {
            if (Objects.equals(menu(), "1")) {
                ArrayList<String> dna_sequence = dna_sequence_creator();
                ArrayList<String> nucleotides = new ArrayList<>(Arrays.asList("A", "T", "G", "C"));
                String new_nucleotide;
                while(true){
                    System.out.println("Ingrese sus nucleotidos\n(Recuerde que la estructura genetica\ndel ser humano se basa en\nlas bases nitrogenadas: A, T, C, G)\n");
                    new_nucleotide = sc.next();
                    if(!dna_fill_valid(new_nucleotide.toUpperCase(), nucleotides)){
                        System.out.println("Nucleotidos no validos, o no perteneciente a la genetica humana, intente de nuevo");
                        continue;
                    } else {
                        dna_sequence.add(new_nucleotide.toUpperCase());
                        print_sequence(dna_sequence);
                    }
                    if(!is_sequence_full(dna_sequence)){
                        System.out.println("Llenado de la secuencia terminado");
                        break;
                    }
                }
                System.out.println("Veamos si es mutante...");
                if(is_mutant(dna_sequence)){
                    System.out.println(
                            "   Es mutante!                  ▓▓         \n"+
                            "                                ▓▓▓        \n"+
                            "                              ▓▓▓ ▓▓       \n"+
                            "                             ▓▓▓   ▓▓      \n"+
                            "                            ▓▓ ▓▓▓  ▓▓▓    \n"+
                            "               ░  ░░      ▓▓▓▓▓▓▓▓▓▓▓      \n"+
                            "               ░  ░░  ▓▓▓▓▓▓▓              \n"+
                            "             ░  ░   ▓▓▓ ▓▓ ▓▓              \n"+
                            "            ░░░    ▓ ▓▓  ▓▓▓▓              \n"+
                            "                ▓     ▓▓  ▓▓               \n"+
                            "               ▓▓      ▓▓▓▓▓               \n"+
                            "              ▓▓▓▓▓     ▓▓▓                \n"+
                            "             ▓▓   ▓▓▓▓▓▓▓                  \n"+
                            "             ▓▓▓▓   ▓▓▓                    \n"+
                            "             ▓▓ ▓▓▓▓▓                      \n"+
                            "           ▓▓▓▓▓▓                          \n"+
                            "       ▓▓▓▓  ▓▓                            \n"+
                            "    ▓▓▓  ▓▓▓ ▓▓                            \n"+
                            "  ▓▓▓▓▓▓▓   ▓▓                             \n"+
                            " ▓▓▓     ▓▓▓▓                              \n"+
                            " ▓▓▓▓▓▓▓▓▓▓▓                               \n"+
                            "▓      ▓▓▓                                 \n"
                    );
                    System.out.println("Quiere volver a repetir el proceso?");
                    choice = sc.next();
                    if(choice_valid(choice)){
                        continue;
                    } else break;
                } else {
                    System.out.println(
                            "              █          █                           \n"+
                            "              █          █       ░                   \n"+
                            "               ██████████                            \n"+
                            "          ░     ████████    No es mutante...         \n"+
                            "                  ████                               \n"+
                            "                 ██  ██                              \n"+
                            "                █      █                             \n"+
                            "              █          █                           \n"+
                            "              █          █                           \n"+
                            "              █          █                           \n"+
                            "              █          █                           \n"+
                            "    ░           █      █                             \n"+
                            "                 ██  ██                              \n"+
                            "                  ████                               \n"+
                            "          ░     ████████                             \n"+
                            "               ██████████                            \n"+
                            "              █          █                           \n"+
                            "              █          █                           \n"
                    );
                    System.out.println("Quiere volver a repetir el proceso?");
                    choice = sc.next();
                    if(choice_valid(choice)){
                        continue;
                    } else break;
                }

            } else return;
        }
    }
    public boolean dna_fill_valid(String nucleotide_local, ArrayList<String> nucleotide_list_local){                       //Metodo booleano para verificar que los nucelotidos de entrada sean validos,
        String[] nucleotide_input_list;                                                                                    //contengan solo ATGC y dispongan de 6 caracteres
        int nucleotide_summatory_bool;
        nucleotide_input_list = nucleotide_local.split("");
        nucleotide_summatory_bool = 0;
        for(int nitro_base = 0;nitro_base < nucleotide_input_list.length; nitro_base++){
            for(String iterable_nucleotide: nucleotide_input_list[nitro_base].split("")){
                if(nucleotide_list_local.contains(iterable_nucleotide)){
                    nucleotide_summatory_bool+=1;
                }
            }
        }
        if(nucleotide_local.length()!=6){
            return false;
        }
        if(nucleotide_summatory_bool!=6){
            return false;
        } else return true;
    }

    public String menu() {                                                          //Metodo booleano para imprimir un menu
        String choice_local;
        while (true) {
            System.out.println(
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░Bienvenido al sistema de        \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░reclutamiento de mutantes!      \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░█░░░░░░░░░░░░Porfavor, ingrese una opcion!   \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒█░░█░░█░░░░░░░░░░1) Verificar ADN                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░█░░█░█░▓░░░░░░░2) Salir                        \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░████████████████░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░█░░█░██░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒█░░█░░█░░██░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░█░░█░░██░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█▒█░░█░░███░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░█░░▓██░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░░░██████████▓█████░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░░██░▓░░█░░███░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░░█▓░█░░█░░█░█░░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░██░█░░█░░█░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░░░███░░█░░█░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░▒█▓▒██░░█░▒███░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                \n" +
                            "░░░░░░░░░░░██▒█░▓░░██░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                \n" +
                            "░░░░░░░░░░░░░█░█░░███░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                \n" +
                            "░░░░░░░░░░░░░░█░░█░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░█░▓█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n" +
                            "░░░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░                                \n"
            );
            Scanner sc = new Scanner(System.in);
            choice_local = sc.next();
            if (!Objects.equals(choice_local, "1") && !Objects.equals(choice_local, "2")) {
                System.out.println("Su eleccion no corresponde con ninguna opcion expresada, intente de nuevo");
                continue;
            } else break;
        }
        return choice_local;
    }
    public void print_sequence(ArrayList<String> dna_sequence_local){                             //Metodo para imprimir la secuencia
        String[] dna_sequence_local_list = new String[dna_sequence_local.size()];
        dna_sequence_local_list = dna_sequence_local.toArray(dna_sequence_local_list);
        for(int row = 0; row < dna_sequence_local.size(); row++){
            for(int column = 0; column < 6; column++){
                System.out.print("[ "+(dna_sequence_local_list[row].charAt(column))+" ]");
            }
            System.out.println();
        }
    }
    public ArrayList<String> dna_sequence_creator(){                                                    //Metodo creador de la matriz de la secuencia de adn
        ArrayList<String> sequence_blanck = new ArrayList<>(6);
        return sequence_blanck;
    }
    public boolean is_sequence_full(ArrayList<String> dna_sequence_local){                             //Metodo booleano que verifica que la secuencia no tenga mas de 36 nucleotidos
        int nucleotide_summatory = 0;
        for(int row = 0; row < dna_sequence_local.size(); row++){
            for(int column = 0; column < dna_sequence_local.get(row).length(); column++){
                nucleotide_summatory+=1;
            }
        }
        if(nucleotide_summatory>=36){
            return false;
        } else return true;
    }
    public boolean choice_valid(String choice_local){                                                       //Metodo booleano para validar la eleccion de reinicio al final
        Scanner sc = new Scanner(System.in);
        while(!choice_local.equalsIgnoreCase("si") && !choice_local.equalsIgnoreCase("no")){
            System.out.println("Solo se acepta si o no, intente de nuevo");
        choice_local = sc.next();
        if(!choice_local.equalsIgnoreCase("si") && !choice_local.equalsIgnoreCase("no")){
            continue;
            } else break;
        }
        if(choice_local.equals("si")){
            return true;
        } else return false;
    }
}

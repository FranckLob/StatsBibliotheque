package Brief2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Brief2 {

    public static void main(String[] args) {

        // création d'une arrayList à partir des fichiers passés en argument
        // cette arraylist contiendra la liste des fichiers, elle sera modifiable
        ArrayList<String> theFiles = new ArrayList<String>();
        for (int i = 0; i != args.length; ++i) {
            theFiles.add(args[i]);
        }

        // choix de l'utilisateur
        int choice = 0;
        // les différentes options sont proposées tant que l'utilisateur n'a pas fait le choix de quitter (choix 5)
        do {
            try {
                // menu
                System.out.println("------------------");
                System.out.println("| MENU PRINCIPAL |");
                System.out.println("------------------");
                System.out.println("1. Lister les fichiers");
                System.out.println("2. Ajouter un fichier");
                System.out.println("3. Supprimer un fichier");
                System.out.println("4. Afficher des informations sur un livre");
                System.out.println("5. Quitter le programme");
                System.out.println("-> Saisissez votre choix (1 ou 2 ou 3 ou 4 ou 5) : ");
                //
                // prise en compte et traitement du choix de l'utilisateur
                Scanner sc = new Scanner(System.in); // lecture depuis l'entrée standard (clavier)
                choice = sc.nextInt();
                switch (choice) {
                    //
                    // choix 1 : liste des fichiers
                    case 1: {
                        // choix 1 : cas de la liste vide
                        if (theFiles.isEmpty()) {
                            System.out.println("La liste est vide");
                        }
                        // choix 1 : cas de la liste non vide
                        else {
                            for (int j = 0; j != theFiles.size(); ++j) {
                                System.out.println(theFiles.get(j));
                            }
                        }
                        break;
                    }
                    //
                    // choix 2 : ajouter un fichier
                    case 2: {
                        System.out.println("Quel est le nom du fichier à ajouter : ");
                        sc.nextLine();
                        String nameToAdd = sc.nextLine();
                        // choix 2 : fichier à ajouter existant ou inexistant
                        if (theFiles.contains(nameToAdd)) {
                            System.out.println("Ce fichier existe déjà");
                        } else {
                            theFiles.add(nameToAdd);
                        }
                        break;
                    }
                    //
                    // choix 3 : supprimer un fichier
                    case 3: {
                        System.out.println("Quel est le nom du fichier à supprimer : ");
                        sc.nextLine();
                        String nameToRemove = sc.nextLine();
                        // choix 3 : fichier à supprimer existant ou inexistant
                        if (!theFiles.contains(nameToRemove)) {
                            System.out.println("Ce fichier n'existe pas");
                        } else {
                            theFiles.remove(nameToRemove);
                        }
                        break;
                    }
                    //
                    // choix 4 : informations d'un fichier
                    case 4: {
                        //Liste des fichiers
                        System.out.println("Liste des fichiers : ");
                        // Liste vide
                        if (theFiles.isEmpty()) {
                            System.out.println("La liste est vide");
                        }
                        // Liste non vide
                        else {
                            for (int j = 0; j != theFiles.size(); ++j) {
                                System.out.println(theFiles.get(j));
                            }
                            System.out.println("Quel est le nom du fichier sélectionné ?");
                            sc.nextLine();
                            String nameSelected = sc.nextLine();
                            // choix 4 : fichier sélectionné existant ou inexistant
                            if (!theFiles.contains(nameSelected)) {
                                System.out.println("Ce fichier n'existe pas");
                            } else {
                                // si le fichier existe
                                // création d'une hashmap destinée à contenir les mots distincts dans le fichier et, pour chaque mot, le nombre total d'occurrences dans le fichier
                                // si la hashmap n'est pas vide, affichage du nombre de mots distincts ou du nombre total de mots, au choix de l'utilisateur
                                HashMap<String, Integer> hash = fillHash(nameSelected);
                                try {
                                    if (!hash.isEmpty()) {
                                        System.out.println("Statistiques pour le fichier " + nameSelected + " : ");
                                        System.out.println("1. Afficher le nombre de lignes du fichier");
                                        System.out.println("2. Afficher le nombre de mots différents du fichier");
                                        // sc.nextLine();
                                        int choice4 = sc.nextInt();
                                        switch (choice4) {
                                            case 1: {
                                                System.out.println("Nombre de lignes = " + sumValuesHash(hash));
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Nombre de mots différents = " + hash.size());
                                                break;
                                            }
                                            default: {
                                                System.out.println("Votre choix est incorrect");
                                            }
                                        }
                                    } else {
                                        System.out.println("Pas de statistiques disponibles");
                                    }
                                } catch (InputMismatchException s) {
                                    System.out.println("Votre saisie est incorrecte.");
                                }
                            }
                        }
                        break;
                    }
                    //
                    // choix 5 : quitter le programme
                    case 5: {
                        System.out.println("A bientôt ...");
                        break;
                    }
                    //
                    // choix saisi numérique mais non compris entre 1 et 5
                    default: {
                        System.out.println("Votre choix est incorrect. Veuillez recommencer");
                    }
                }
                //
                // choix saisi non numérique
            } catch (InputMismatchException s) {
                System.out.println("Votre saisie est incorrecte. Veuillez recommencer");
            }
            System.out.println(" ");
            //
        } while (choice != 5);
//    fin du main
    }

    //
//
// Fonctions
//
// la fonction fillHash valorise une hashmap<String, Integer> à partir d'un fichier de Strings passé en argument :
// chaque String (ou mot) est une clé, le nombre total de chaque mot dans le fichier constitue la valeur associée à la clé
// la fonction renvoie la hashmap valorisée ou, si fichier non trouvé, une hashmap vide
    public static HashMap<String, Integer> fillHash(String nameFile) {
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        try {
            Scanner sc = new Scanner(new File(nameFile));
            for (int i = 0; sc.hasNextLine(); ++i) {
                String word = sc.nextLine();
                // cas du mot déjà dans la hashmap ou pas encore dans la hashmap
                if (words.containsKey(word)) {
                    Integer j = words.get(word) + 1;
                    words.put(word, j);
                } else {
                    words.put(word, 1);
                }
            }
            // fichier non trouvé
        } catch (FileNotFoundException e) {
            System.out.println("Erreur sur le fichier " + e.getLocalizedMessage());
        }
        return words;
    }

    // la fonction sumValuesHash permet d'obtenir la somme des valeurs des clés d'une hashmap<String, Integer>
    public static int sumValuesHash(HashMap<String, Integer> hash) {
        int sumValues = 0;
        for (String key : hash.keySet()) {
            sumValues = sumValues + hash.get(key);
        }
        return sumValues;
    }
//
// fin de class Brief2
}
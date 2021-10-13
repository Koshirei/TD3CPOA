package fr.nicolas;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Normalisation {
    private HashMap<String, String> traduction;
    private ArrayList<String> prepositions;
    private HashMap<String, String> voieAbrege;
    private String pays;
    private String ville;
    private String codePostal;
    private String voie;
    private String numVoie;

    public Normalisation() {
        this.traduction = new HashMap<>();
        this.traduction.put("letzebuerg", "Luxembourg");
        this.traduction.put("belgium", "Belgique");
        this.traduction.put("Switzerland", "Suisse");
        this.traduction.put("Schweiz", "Suisse");

        this.prepositions = new ArrayList<>();
        this.prepositions.add("à");
        this.prepositions.add("aux");
        this.prepositions.add("le");
        this.prepositions.add("lès");
        this.prepositions.add("sous");
        this.prepositions.add("sur");

        this.voieAbrege = new HashMap<>();
        this.voieAbrege.put("boul", "boulevard");
        this.voieAbrege.put("boul.", "boulevard");
        this.voieAbrege.put("bd", "boulevard");
        this.voieAbrege.put("av.", "avenue");
        this.voieAbrege.put("faub", "faubourg");
        this.voieAbrege.put("fg", "faubourg");
        this.voieAbrege.put("pl", "place");
    }

    public String pays(String pays) {
        pays = pays.trim();
        return this.traduction.get(pays);

    }

    public String ville(String ville) {
        ville = ville.trim();

        // les noms des villes commencent par une majuscule
        char[] villeCharArray = ville.toCharArray();
        villeCharArray[0] = Character.toUpperCase(villeCharArray[0]);
        ville = String.valueOf(villeCharArray);

        // prepositions
        // on imagine que chaque partie de la ville est séparée par un espace ( ou plusieurs )

        String[] villeSplit = ville.split(" ");

        int i = 0;
        for (String a : villeSplit) {
            for (String preposition : this.prepositions) {
                if (a.equals(preposition)) {
                    villeSplit[i] = "-" + villeSplit[i] + "-";

                }
            }

            i += 1;
        }

        ville = String.join("", villeSplit);


        this.setVille(ville);

        return this.ville;

    }

    public void setVille(String ville) {
        if (!Character.isUpperCase(ville.charAt(0))) {
            throw new IllegalArgumentException("Le premier caractère doit être une majuscule");

        } else if (ville.contains(" ")) {
            throw new IllegalArgumentException("La ville ne doit pas contenir d'espaces");

        } else if (ville.contains("-")) {
            // si la ville contient un '-' alors on est censé trouver une preposition

            String[] villeSplit = ville.split("-");
            boolean prepositionTrouvee = false;

            for (String a : villeSplit) {
                for (String preposition : this.prepositions) {
                    if (a.equals(preposition)) {
                        prepositionTrouvee = true;

                    }
                }
            }

            if (prepositionTrouvee) {
                this.ville = ville;

            } else {
                throw new IllegalArgumentException("Il est censé il y a voir une preposition dans la ville");

            }
        } else {
            // autrement c'est tout bon!

            this.ville =  ville;

        }
    }

    public String codePostal(String codePostal) {

        char[] codePostalCharArray = codePostal.toCharArray();

        int i = 0;
        for (char c : codePostalCharArray) {
            if (!Character.isDigit(c)) {
                codePostalCharArray[i] = ' ';
            }

            i += 1;
        }

        ville = String.valueOf(codePostalCharArray);
        ville = ville.trim();

        while (ville.length() != 5) {
            ville = "0" + ville;
        }

        System.out.println(ville);

        return this.codePostal;


    }

    public void setCodePostal(String codePostal) {
        char[] codePostalCharArray = codePostal.toCharArray();

        boolean contientChar = false;

        for (char c : codePostalCharArray) {
            if (!Character.isDigit(c)) {
                contientChar = true;

            }
        }

        if (contientChar) {
            throw new IllegalArgumentException("contient un caractère");

        } else if (codePostal.length() != 5) {
            throw new IllegalArgumentException("doit être égal a 5 caractères");

        } else{
            this.codePostal = codePostal;

        }
    }

    public String voie(String voie) {

        switch (voie) {
            case "boul":
                voie = voie.replace("boul","boulevard");
                break;

            case "boul.":
                voie = voie.replace("boul.","boulevard");
                break;

            case "bd":
                voie = voie.replace("bd","boulevard");
                break;

            case "av.":
                voie = voie.replace("av.","avenue");
                break;

            case "faub.":
                voie = voie.replace("faub.","faubourg");
                break;

            case "fg":
                voie = voie.replace("fg","faubourg");
                break;

            case "pl":
                voie = voie.replace("pl","place");
                break;

        }

        this.setVoie(voie);

        return this.voie;
    }

    public void setVoie(String voie) {
        if (voie.equals("boulevard") || voie.equals("avenue") || voie.equals("faubourg") || voie.equals("place")) {
            this.voie = voie;

        } else {
            throw new IllegalArgumentException("Erreur");

        }
    }

    public String numVoie(String numVoie) {
        String[] numVoieSplit = numVoie.split(" ");

        numVoieSplit[0] = numVoieSplit[0] + ",";



        numVoie = String.join(" ", numVoieSplit);


        setNumVoie(numVoie);

        return this.numVoie;
    }

    public void setNumVoie(String numVoie) {
        if(numVoie.contains(",")) {
            this.numVoie = numVoie;

        } else {
            throw new IllegalArgumentException("erreur");

        }
    }
}

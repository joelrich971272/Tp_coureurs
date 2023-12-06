import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class GestionDesCoureurs {
    private String b ;

   ArrayList<Coureur> coureurs = new ArrayList<>() ;


    public ArrayList<Coureur> getCoureurs() {
        return coureurs;
    }

    public void setCoureurs(ArrayList<Coureur> coureurs) {
        this.coureurs = coureurs;
    }

    public GestionDesCoureurs() throws IOException {
        String s ;
        BufferedReader br ;
        BufferedWriter bw ;
        Random rd = new Random() ;
        Path source = Paths.get("lescoureurs.txt") ;
        br = Files.newBufferedReader(source, Charset.defaultCharset()) ;
        Categorie cat = Categorie.M1;
        int position = 1;


        while ((s = br.readLine()) != null){
            s = s.substring(s.indexOf('\''), s.length() - 2);
            String [] item = s.split(",");
            int duree = rd.nextInt(3602, 10800);
            switch (Integer.parseInt(item[2].trim())) {
                case 1:
                    cat = Categorie.Elite_1;
                    break;
                case 2:
                    cat = Categorie.Elite_2;
                    break;
                case 3:
                    cat = Categorie.M1;
                    break;
                case 4:
                    cat = Categorie.M2;
                    break;
                case 5:
                    cat = Categorie.M3;
                    break;
                case 6:
                    cat = Categorie.M4;
                    break;
                case 7:
                    cat = Categorie.M5;
                    break;
                case 8:
                    cat = Categorie.M6;
                    break;
                case 9:
                    cat = Categorie.M7;
                    break;
                case 10:
                    cat = Categorie.M8;
                    break;
                case 11:
                    cat = Categorie.M9;
                    break;
            }
            Coureur c = null;
            if(position++ <500) {
                c = new Coureur(Genre.M, item[0].trim(), item[1].trim(), LocalTime.ofSecondOfDay(duree), cat);
            } else {
                c = new Coureur(Genre.F, item[0].trim(), item[1].trim(), LocalTime.ofSecondOfDay(duree), cat);
            }
            coureurs.add(c);



        }
        Path coureur = Paths.get("coureur.txt");
        bw = Files.newBufferedWriter(coureur,Charset.defaultCharset(), StandardOpenOption.APPEND);
        while (b = bw.write(coureurs);

    }


    public GestionDesCoureurs(ArrayList<Coureur> coureurs) {

        this.coureurs = coureurs;
    }
}

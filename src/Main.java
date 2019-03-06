import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Slide> slides = new ArrayList<>();
    static boolean slideVfull = true;
    static int nbrV=0;
    static SlideV s;

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("b.txt");
        Scanner scanner = new Scanner(path);

        String nbrImg = scanner.nextLine();
        ArrayList<Image> images = new ArrayList();

        int idLigne = 0;

        while(scanner.hasNextLine()){
            //process each line
            String line = scanner.nextLine();
            String[] words = line.split(" ");

            Image im = new Image(idLigne, words[0],Integer.parseInt(words[1]));

            int i=2;
            while (i<words.length){
                //System.out.println(words[i]+" ");
                im.setTag(words[i]);
                i++;
            }

            //System.out.println("\n"+images.get(idLigne).toString());
            //System.out.println(idLigne);
            //consSlide(im);
            slides.add(new SlideH(im));
            idLigne++;
            words = null;
            im = null;
        }
        scanner.close();

        ArrayList<Slide> Nslides = new ArrayList<>();

        int size = slides.size();

        Nslides.add(slides.get(0));
        slides.remove(0);
        int j=0;
        while(Nslides.size() != size){
            int limit=0;
            int max=0, id=0;
            if (slides.size() >79999) limit=79999;
            else limit=slides.size() ;

            for (int i=0;i<limit;i++){
                int tmp =Helper.score(Nslides.get(j),slides.get(i));
                if(max < tmp ){
                    max = tmp;
                    id = i;
                }
            }
            Nslides.add(slides.get(id));
            slides.remove(id);
            j++;
            if(j%100==0) System.out.println(j+"\n");
        }


        //_____________________________________________

        BufferedWriter writer = new BufferedWriter(new FileWriter("outB.txt"));
        writer.write(Nslides.size()+"\n");
        for (Slide sl: Nslides ) {
            writer.append(sl.getId()+"\n");

        }

        writer.close();

    }

    public static void consSlide(Image img){

        if (img.getOrientation().contains("H")){
            slides.add(new SlideH(img));
        }else{
            if (slideVfull){
                s = new SlideV(img);
                slideVfull = false;
            }else {
                s.setImage2(img);
                slideVfull = true;
                slides.add(s);
            }
        }
    }


}

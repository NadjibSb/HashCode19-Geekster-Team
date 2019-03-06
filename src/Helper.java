public class Helper {

    public static int score(Slide slide1, Slide slide2){
        int nbr1 = slide1.getNbrTags();
        int nbr2 = slide2.getNbrTags();
        int similar = 0;

        for (String tag: slide1.getTags()) {
            if (slide2.getTags().contains(tag)){
                nbr1--;
                nbr2--;
                similar++;
            }
        }

        return min(nbr1,nbr2,similar);
    }

    public static int min(int i1, int i2, int i3){
        int x= 0;
        if (i1<i2){
            if (i1<i3){
                x=i1;
            }else{
                x=i3;
            }
        }else{
            if (i2<i3){
                x=i2;
            }else{
                x=i3;
            }
        }
        return x;
    }
}

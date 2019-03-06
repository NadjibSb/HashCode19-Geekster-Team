import java.util.ArrayList;

public class SlideV extends Slide {
    private Image image1;
    private Image image2;

    public SlideV(Image image1) {
        this.image1 = image1;
    }

    @Override
    public int getNbrTags() {
        return image1.getNbrTags()+image2.getNbrTags();
    }

    @Override
    public boolean contains(String s) {
        if (image2.getTags().contains(s)) return true;
        else if (image1.getTags().contains(s)) return true;
        else return false;
    }

    @Override
    public ArrayList<String> getTags() {
        ArrayList<String> s1 = image1.getTags();
        ArrayList<String> s2 = image2.getTags();

        s1.removeAll(s2);
        s1.addAll(s2);

        return s1;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    @Override
    public String getId() {
        return image1.getId()+" "+image2.getId();
    }
}

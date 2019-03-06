import java.util.ArrayList;

public class SlideH extends Slide {
    private Image image;

    public Image getImage() {
        return image;
    }

    public SlideH(Image image) {
        this.image = image;
    }

    @Override
    public int getNbrTags() {
        return image.getNbrTags();
    }

    @Override
    public boolean contains(String s) {
        return image.getTags().contains(s);
    }

    @Override
    public ArrayList<String> getTags() {
        return image.getTags();
    }

    @Override
    public String getId() {
        return image.getId()+"";
    }
}

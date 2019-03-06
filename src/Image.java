import java.util.ArrayList;

public class Image {
    private int Id;
    private String orientation;
    private int nbrTags;
    private ArrayList<String> tags;

    public Image(int Id,String orientation,int nbrTags) {
        this.Id = Id;
        this.orientation = orientation;
        this.nbrTags = nbrTags;
        this.tags = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTag(String tag){
        this.tags.add(tag);
    }

    @Override
    public String toString() {

        String s;
        s= "id : "+ this.Id;
        s+= " , Orient : "+ this.orientation;

        return s;
    }

    public int getNbrTags() {
        return nbrTags;
    }

    public String getOrientation() {
        return orientation;
    }
}

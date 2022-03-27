package visa;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote obj = new RansomNote();
        System.out.println(obj.ransomNote( ";alksjdfb","ab"));
    }
    int ransomNote(String text, String note)
    {
        List t = new ArrayList();
        int i;
        for (i = 0; i < text.length(); i++) {
            t.add( text.charAt(i));
        }

        for(int j =0; j< note.length();j++){
            //if(note.charAt(j))
                if(t.contains(note.charAt(j)) && note.charAt(j)!=' ')
                {
                    continue;
                }
                    else{
                        return 0;
                }

        }
        return 1;
    }
}

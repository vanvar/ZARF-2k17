package zarf2k17.cs2k18.zarf2k17;

/**
 * Created by MSaqib on 12-04-2017.
 */

public class Developer {

    public int image;
    public String facebook_url;
    public String github_url;
    public String name;

    public Developer(String a, int b, String c, String d) {
        name = a;
        image = b;
        facebook_url = c;
        github_url = d;
    }

    public Developer(String a, int b, String c) {
        name = a;
        image = b;
        facebook_url = c;
        github_url = null;
    }
}

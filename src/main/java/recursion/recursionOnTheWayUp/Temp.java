package recursion.recursionOnTheWayUp;

public class Temp {
    public static void main(String[] args) {
        String str="abcded";
        System.out.println(str.substring(0));
        System.out.println(str.substring(1));
        System.out.println(str.substring(2));;
        System.out.println(str.substring(3));;


        int x=26;
        char ch ='a';
        System.out.println((int)ch);

       // 97-26
        //-52
        int y=97;
        System.out.println((char)(y));

        int temp= ch - '`';
        System.out.println("::"+temp);
        char code=(char)('a'+temp-1);
        System.out.println(code);

        //System.out.println((char)('a'+3-1));
        System.out.println("character encodings");
        System.out.println((char)('a'+1));
        System.out.println((char)('a'+2));
        System.out.println((char)('a'+3));
        System.out.println((char)('a'+4));
        System.out.println((char)('a'+5));
        System.out.println((char)('a'+6));
        System.out.println((char)('a'+7));
        System.out.println((char)('a'+8));
        System.out.println((char)('a'+23));
        System.out.println((char)('a'+24));
        System.out.println((char)('a'+25));
        System.out.println("Correct Encodings");
        System.out.println((char)('a'-1+1));
        System.out.println((char)('a'-1+2));
        System.out.println((char)('a'-1+3));
        System.out.println((char)('a'-1+4));
        System.out.println((char)('a'-1+5));
        System.out.println((char)('a'-1+6));
        System.out.println((char)('a'-1+7));
        System.out.println((char)('a'-1+8));
        System.out.println((char)('a'-1+9));
        System.out.println((char)('a'-1+10));
        System.out.println((char)('a'-1+11));
        System.out.println((char)('a'-1+12));
        System.out.println((char)('a'-1+13));
        System.out.println((char)('a'-1+14));



        int solve1=1;
        int solve2=2;

        String ans1=(char)('a'-1+solve1)+"";
        String ans2=(char)('a'-1+solve2)+"";
        System.out.println(ans1+":"+ans2);



    }
}

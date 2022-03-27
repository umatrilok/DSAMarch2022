package BasicDataStructure.GenericTreePractice;

public class ReturnInLoop {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static boolean func()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(i);
            if(i==6)
                return false;
        }
        return true;
    }
}

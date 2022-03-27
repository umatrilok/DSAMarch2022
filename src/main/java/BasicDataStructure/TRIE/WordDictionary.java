package BasicDataStructure.TRIE;
//221 Design add and search words Data Structure
//'.' Dot indicates any character from a to z
//if you get upper chase letters take size of TrieNode[] from 26 to 256 and handle all
import java.io.BufferedReader;
import java.io.InputStreamReader;

class WordDictionary {

    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd=false;
            children=new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp=root;

        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);

            if(temp.children[ch-'a']==null)
            {
                temp.children[ch-'a']=new TrieNode();
            }

            temp=temp.children[ch-'a'];
        }
        temp.isEnd=true;
    }

    public boolean find(TrieNode temp,String word,int idx)
    {
        if(idx==word.length())
        {
            return temp.isEnd;
        }

        char ch=word.charAt(idx);

        if(ch=='.')
        {
            for(int i=0;i<26;i++)
            {
                if(temp.children[i]!=null)
                {
                    boolean ans=find(temp.children[i],word,idx+1);
                    if(ans==true) return true;
                }
            }
            return false;
        }
        else
        {
            if(temp.children[ch-'a']==null) return false;

            temp=temp.children[ch-'a'];
            return find(temp,word,idx+1);
        }
    }

    public boolean search(String word) {
        TrieNode temp=root;

        return find(temp,word,0);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        WordDictionary obj= new WordDictionary();

        System.out.println("add,search");

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                String word = str.split(" ")[1];
                obj.addWord(word);
            }
            else if (str.startsWith("search")) {
                String word = str.split(" ")[1];
                System.out.println(obj.search(word));
            }

            str = br.readLine();
        }
    }
}
/*
add,search
add umadubaka
search uma.ubaka
true
add dubaka
search ....ka
true*/
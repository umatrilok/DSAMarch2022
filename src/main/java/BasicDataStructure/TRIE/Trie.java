package BasicDataStructure.TRIE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            isEnd =false;
            children= new TrieNode[26];
        }
    }

    TrieNode root;
    public Trie()
    {
        root=new TrieNode();
    }

    public void insert(String word){
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
    public boolean display(String word)
    {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
            char ch =word.charAt(i);
            if(temp.children[ch-'a']==null)
            {
                return false;
            }
            System.out.println("TrieNode child no:"+i+" "+" its index:"+(int)(ch-'a'));
            temp=temp.children[ch-'a'];
        }
        return temp.isEnd;
    }

    public boolean search(String word)
    {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
            char ch =word.charAt(i);
            if(temp.children[ch-'a']==null)
            {
                return false;
            }
            temp=temp.children[ch-'a'];
        }
        return temp.isEnd;
    }
    public boolean startsWith(String prefix)
    {
        TrieNode temp=root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch =prefix.charAt(i);
            if(temp.children[ch-'a']==null)
            {
                return false;
            }
            temp=temp.children[ch-'a'];
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        Trie obj= new Trie();

        System.out.println("insert,prefix,search,display");

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("insert")) {
                String word = str.split(" ")[1];
                obj.insert(word);
            } else if (str.startsWith("prefix")) {
                String word = str.split(" ")[1];
                System.out.println(obj.startsWith(word));
            } else if (str.startsWith("search")) {
                String word = str.split(" ")[1];
                System.out.println(obj.search(word));
            }
            else if (str.startsWith("display")) {
                String word = str.split(" ")[1];
                System.out.println(obj.display(word));
            }
            str = br.readLine();
        }
    }
}
/*
* insert,prefix,search,display
insert uma
insert navya
insert umadubaka
insert navyadubaka
search dubaka
false
prefix dubaka
false
prefix uma
true
display uma
TrieNode child no:0  its index:20
TrieNode child no:1  its index:12
TrieNode child no:2  its index:0
true
display navyadubaka
TrieNode child no:0  its index:13
TrieNode child no:1  its index:0
TrieNode child no:2  its index:21
TrieNode child no:3  its index:24
TrieNode child no:4  its index:0
TrieNode child no:5  its index:3
TrieNode child no:6  its index:20
TrieNode child no:7  its index:1
TrieNode child no:8  its index:0
TrieNode child no:9  its index:10
TrieNode child no:10  its index:0
true
display umadubaka
TrieNode child no:0  its index:20
TrieNode child no:1  its index:12
TrieNode child no:2  its index:0
TrieNode child no:3  its index:3
TrieNode child no:4  its index:20
TrieNode child no:5  its index:1
TrieNode child no:6  its index:0
TrieNode child no:7  its index:10
TrieNode child no:8  its index:0
true
*/
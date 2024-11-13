package Graph.DFS_BFS;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hot", endWord = "dog";
        List<String> wordlist = Arrays.asList(new String[]{"hot","dog"});
        System.out.print(ladderLength(beginWord,endWord,wordlist));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        int distance=1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String text = queue.poll();
                if(text.equals(endWord)) return distance;

                for (int i1 = 0; i1 < text.length(); i1++) {
                    char[] temp = text.toCharArray();
                    for(char j = 'a'; j <= 'z'; j++ ){
                        char arr[] = text.toCharArray();
                        arr[j] = (char) j;

                        String newWord = new String(arr);
                        if(set.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord);
                            queue.add(newWord);
                        }
                    }
                }
             //   System.out.println(q);
            }
            distance++;
        }
        return 0;

    }
}

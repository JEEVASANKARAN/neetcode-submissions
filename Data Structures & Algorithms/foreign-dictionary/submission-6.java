class Solution {
    public String foreignDictionary(String[] words) {
      boolean[] present = new boolean[26];
      int unique = 0;

      for(String word : words){
        for(char c : word.toCharArray()){
            if(!present[c - 'a']){
                present[c - 'a'] = true;
                unique++;
            }
        }
      }

      int[] indegree = new int[26];
      boolean[][] edges = new boolean[26][26];
      HashSet<Integer>[] graph = new HashSet[26];
      for(int i = 0; i < 26; i++) graph[i] = new HashSet<>();
      for(int i = 0; i < words.length - 1; i++){
        String s1 = words[i];
        String s2 = words[i + 1];

        if(s1.length() > s2.length() && s1.startsWith(s2)) return "";

        int len = Math.min(s1.length(), s2.length());

        for(int j = 0; j < len; j++){

            if(s1.charAt(j) != s2.charAt(j)){
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';

                if(!edges[u][v]){
                    edges[u][v] = true;
                    indegree[v]++;
                    graph[u].add(v);
                }
                break;
            }
        }
      }

      Queue<Integer> q = new LinkedList<>();
      StringBuilder res = new StringBuilder();

      for(int i = 0; i < 26; i++) if(present[i] && indegree[i] == 0) q.add(i);

      while(!q.isEmpty()){
        int curr = q.poll();
        res.append((char)(curr + 'a'));

        for(int neigh : graph[curr]){
            indegree[neigh]--;
            if(indegree[neigh] == 0) q.add(neigh);
        }
      }

      return (unique == res.length()) ? res.toString() : "";
    }
}

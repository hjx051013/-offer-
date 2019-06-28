import java.util.*;

public class FindSubString {
    public static void main(String[] args) {
        System.out.println("hello world");
        Solution64 s = new Solution64();
        String[] words = {"foo","bar"};
        String str = "barfoothefoobarman";
        List<Integer> res = s.findSubstring(str, words);
        for(Integer e:res) {
            System.out.print(e+" ");
        }
    }

}
class Solution64 {
    public List<Integer> findSubstring(String s, String[] words) {
        // Set<String> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> map= new HashMap<>();
        for(String word: words) {
            if(map.containsKey(word)) map.put(word, map.get(word)+1);
            else map.put(word,1);
        }
        List<Pair<Integer,String>> list = new ArrayList<>();
        for(String word:map.keySet()) {
            int start = 0;
            if(s.indexOf(word) < 0) return res;
            while(start<s.length()&&(start = s.substring(start).indexOf(word)) > 0) {
                list.add(new Pair<Integer,String>(start,word));
                start += word.length();
            }
        }
        
        list.sort(new Comparator<Pair<Integer,String>>() {
            public int compare(Pair<Integer,String> p1, Pair<Integer,String> p2) {
                if(p1.val1 < p2.val1) return -1;
                else if(p1.val1 == p2.val1) return 0;
                else return 1;
            }
        });

        Map<String, Integer> example = new HashMap<>();
        for(int i = 0; i <= list.size()-words.length; i++) {
            boolean valid = isValid(map,list,i,words.length);
            if(valid) res.add(list.get(i).val1);
        }

        return res;
    }

    private boolean isValid(Map<String, Integer> map, List<Pair<Integer,String>> list, int index, int num) {
        Map<String, Integer> strCnt = new HashMap<>();
        for(int i = 0; i < index+num; i++) {
            Pair<Integer,String> p = list.get(i);
            if(strCnt.containsKey(p.val2)) {
                strCnt.put(p.val2,strCnt.get(p.val2)+1);
            } else {
                strCnt.put(p.val2,1);
            }
        }
        for(String str:map.keySet()) {
            if(!strCnt.containsKey(str)) return false;
            if(strCnt.get(str)!=map.get(str)) return false;
        }

        return true;
    }
}

class Pair<T1,T2>
{
    public T1 val1;
    public T2 val2;
    public Pair(T1 v1, T2 v2) {
        val1 = v1;
        val2 = v2;
    }
}

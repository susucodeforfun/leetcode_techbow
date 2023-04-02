package DFS.Partition;

import java.util.LinkedList;
import java.util.List;

public class Lc282Demo02 {
    public List<String> addOperators(String num, int target) {

        char[] nu = num.toCharArray();
        List<String> res = new LinkedList<String>();
        if(num == null){
            return res;
        }
        dfs(res, new StringBuilder(), 0, nu, target,0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, int index, char[] nu, int target,int pre){
        if(index == nu.length && target == 0){
            res.add(path.toString());
            return;
        }
        if(index >nu.length || target <0){
            return;
        }
        int val = 0;
        for(int i = index; i < nu.length; i++){
            val = val*10+(nu[i]-'0');
            int l = path.length();
            if(l != 0){
                path.append("+");
                path.append(val);
                dfs(res, path, i+1, nu, target-val,val);
                path.setLength(l);

                path.append("-");
                path.append(Integer.valueOf(val));
                dfs(res, path, i+1, nu, target+val,-val);
                path.setLength(l);

                path.append("*");
                path.append(Integer.valueOf(val));
                dfs(res, path, i+1, nu,target+pre-pre*val ,pre*val);
                path.setLength(l);
            }
            else{
                path.append(Integer.valueOf(val));
                dfs(res, path, i+1, nu, target-val,val);
                path.setLength(0);
            }
            if(val == 0){
                break;
            }

        }
    }

    public static void main(String[] args) {
        LinkedList<String> res = new LinkedList();
        Lc282Demo02 lc = new Lc282Demo02();
        String s = "105";
        lc.addOperators(s,5);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}

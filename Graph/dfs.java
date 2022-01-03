import java.util.*;

public class Main
{
    static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> dfs_lst=new ArrayList<Integer>();

	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of nodes and edges in the graph :");
		int n=sc.nextInt();
		int e=sc.nextInt();
		for(int i=0;i<=n;i++)
		    adj.add(new ArrayList<Integer>());
		System.out.println("Enter the edges :");
		for(int i=0;i<e;i++){
		    int e1=sc.nextInt();
		    int e2=sc.nextInt();
		    buildGraph(e1,e2);
		}
		System.out.println("Enter the node from which you want to traverse :");
		int target=sc.nextInt();
		System.out.println(dfs_caller(target));
	}
	public static void buildGraph(int e1,int e2){
	    adj.get(e1).add(e2);
	    adj.get(e2).add(e1);
	}

	public static void dfs(int n, boolean vis[]){
	    vis[n]=true;
	    dfs_lst.add(n);
	    for(Integer e:adj.get(n)){
	        if(!vis[e]){
	            dfs(e,vis);
	        }
	    }
	}
	public static ArrayList<Integer> dfs_caller(int n){
	    boolean[] vis=new boolean[adj.size()];
	    dfs(n,vis);
	    for(int i=1;i<adj.size();i++){
	        if(!vis[i]){
	            dfs(i,vis);
	        }
	    }
	    return dfs_lst;
	}
}

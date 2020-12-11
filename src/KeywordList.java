import java.util.ArrayList;


public class KeywordList {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		lst.add(keyword);
		System.out.println("Done");
    }
	
	public void find(String s){
		int maxValue = -1;
		int maxIndex = -1;
		for(int i=0; i<lst.size(); i++){
			int lcs = findLCS(lst.get(i).name, s);
			System.out.println(lcs);
			if(lcs > maxValue){
				maxValue = lcs;
				maxIndex = i;
			}
		}
		System.out.println(lst.get(maxIndex).toString());
	}
	
	// upper and lower character is NOT matter
	public int findLCS(String x, String y){
		//1. fill this method
		int length[][]=new int[x.length()+1][y.length()+1];
		for(int i=0;i<=x.length();i++) length[i][0]=0;
		for(int j=0;j<=y.length();j++) length[0][j]=0;
		for (int i=0; i<x.length(); i++) {
			for(int j=0; j<y.length(); j++) {
				if(Character.toLowerCase(x.charAt(i))==Character.toLowerCase(y.charAt(j))) {
					length[i+1][j+1] = length[i][j] + 1;
				}
				else {
					length[i+1][j+1] = length[i][j+1]>length[i+1][j]?length[i][j+1]:length[i+1][j];
				}
			}
		}
		return length[x.length()][y.length()];
	}
	
	private void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
				if(j==matrix[0].length-1)System.out.print("\n");
			}
		}
	}
}

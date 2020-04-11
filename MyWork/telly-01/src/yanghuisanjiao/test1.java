package yanghuisanjiao;

public class test1 {
	public static void main(String[] args){
		int hang=8;
		yanghuisanjiao(hang);
		//maopao();
	}
/**
 * 
 * @author Administrator 2020-4-8
 * @name yanghuisanjiao
 * @type test1
 * @param @param hang
 * @return void
 */
	public static void yanghuisanjiao(int hang){
		int[][] a=new int[hang][hang];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(i==j){
					a[i][j]=1;
				}
				else if(j==0||i==j)
				{
					a[i][j]=1;
				}
				else if(i!=0&&j!=0)
				{
					a[i][j]=a[i-1][j-1]+a[i-1][j];
				}
			}
		}
		for(int i=0;i<a.length;i++){
			for(int j=0;j<=i;j++){
				System.out.print("  "+a[i][j]);
			}
			System.out.println();
		}
	
	}
/**
 * 
 * @author Administrator 2020-4-8
 * @param 
 * @return void
 * @todo TODO
 */
	public static void maopao(){
		int [] a={1,4,2,6,4,3,2};
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j]){
					int k=a[i];
					a[i]=a[j];
					a[j]=k;
				}
			}
		}
		for(int i:a){
			System.out.print("  "+i);
		}
	}
}

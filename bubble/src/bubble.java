public class bubble
{
    public static void main(String[] args) {
        int data[]=new int []{21,1,90,5,35,74,65,58};
        for(int x=0;x<data.length;x++){
            System.out.print(data[x]+"、");
        }
        sort(data);
        print(data);
    }
    public static void sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }
    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"、");
        }
    }
}

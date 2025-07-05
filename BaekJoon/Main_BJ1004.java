package alone;
/*

 */
public class Main_BJ1004 {                          //어린 왕자
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int start[] = new int[2];//출발점 입력
        int end[] = new int[2];//도착점 입력
        int circle[] = new int[3];//원 입력
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            start[0] = Integer.parseInt(st.nextToken());//출발 x
            start[1] = Integer.parseInt(st.nextToken());//출발 y
            end[0] = Integer.parseInt(st.nextToken());//도착 x
            end[1] = Integer.parseInt(st.nextToken());//도착 y
            int n = Integer.parseInt(br.readLine());
            
        }
    }
}

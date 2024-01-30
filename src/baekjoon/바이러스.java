package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

    static int[] arr;

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            arr[y] = x;
        } else if(x > y) {
            arr[x] = y;
        }
    }

    static int find(int x) {
        return arr[x] == x ? x : find(arr[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for(int i = 1; i<=n; i++) {
            arr[i] = i;
        }

        while(m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int cnt = 0;
        for (int num : arr) {
            if(find(num)==1) {
                cnt++;
            }
        }

        System.out.print(cnt==1 ? 0 : cnt-1);
    }

}
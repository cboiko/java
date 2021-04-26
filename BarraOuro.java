import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * URI 2666 https://www.urionlinejudge.com.br/judge/en/problems/view/2666 Paulo
 * Cezar, Maratona 2017, Imposto real 
 */
class Edge {
    Vertex v;
    int w;

    Edge(Vertex vv, int ww) {
        v = vv;
        w = ww;
    }
}

class Vertex {
    static int C;
    int tax;
    List<Edge> adj = new ArrayList<>();

    public void path(Vertex to, int dist) {
        adj.add(new Edge(to, dist));
    }

    public int doit() {
        return doit(null);
    }

    public int doit(Vertex parent) {
        int res = 0;
        for (Edge e : adj) {
            if (e.v == parent)
                continue;
            res += e.v.doit(this);
            int use_it = (e.v.tax + C - 1) / C;
            res += use_it * 2 * e.w;
            tax += e.v.tax;
        }
        return res;
    }
}

public class BarraOuro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Vertex.C = in.nextInt();

        Vertex[] reign = new Vertex[n];
        for (int i = 0; i < n; ++i) {
            reign[i] = new Vertex();
            reign[i].tax = in.nextInt();
        }

        for (int i = 1; i < n; ++i) {
            int a, b, c;
            a = in.nextInt() - 1;
            b = in.nextInt() - 1;
            c = in.nextInt();
            reign[a].path(reign[b], c);
            reign[b].path(reign[a], c);
        }

        System.out.println(reign[0].doit());
        in.close();
    }
}
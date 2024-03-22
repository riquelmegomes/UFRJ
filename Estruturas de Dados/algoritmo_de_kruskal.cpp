#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;
 
struct Edge {
    int src, dest, weight;
};
 
// Objeto de comparação a ser usado para ordenar as arestas
struct compare {
    bool operator() (Edge const &a, Edge const &b) const {
        return a.weight > b.weight;
    }
};
 
class DisjointSet {
    unordered_map<int, int> parent;
 
public:
    void makeSet(int n) {
        // cria n conjuntos disjuntos (um para cada vértice)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
 
    // Encontra a raiz do conjunto ao qual pertence o elemento 'k'
    int Find(int k) {
        // se 'k' for raiz
        if (parent[k] == k) {
            return k;
        }
        //recorre para o pai até encontrarmos a raiz
        return Find(parent[k]);
    }
 
    // Realiza união de dois subconjuntos
    void Union(int a, int b) {
        int x = Find(a);
        int y = Find(b);
        parent[x] = y;
    }
};
 
// Função para construir MST usando o algoritmo de Kruskal
vector<Edge> runKruskalAlgorithm(vector<Edge> edges, int n) {
    vector<Edge> MST;
    DisjointSet ds;
    
    ds.makeSet(n);
    sort(edges.begin(), edges.end(), compare());
    while (MST.size() != (unsigned) n - 1) {
        
        // considera a próxima aresta com peso mínimo do gráfico
        Edge next_edge = edges.back();
        edges.pop_back();
 
        // encontra a raiz dos conjuntos para os quais dois endpoints
        // os vértices da próxima aresta pertencem
        int x = ds.Find(next_edge.src);
        int y = ds.Find(next_edge.dest);
 
        // se ambos os endpoints tiverem pais diferentes, eles pertencem a
        // diferentes componentes conectados e podem ser incluídos no MST
        if (x != y) {
            MST.push_back(next_edge);
            ds.Union(x, y);
        }
    }
    return MST;
}
 
int main() {
    int qtd_vertices, qtd_arestas;
    int i, vert1, vert2, peso;
    vector<Edge> edges;

    scanf("%d %d", &qtd_vertices, &qtd_arestas);
    for(i = 0; i < qtd_arestas; i++) {
        scanf("%d %d %d", &vert1, &vert2, &peso);
        edges.push_back(Edge{vert1, vert2, peso});
    }
 
    // constrói a arvore geradora minima
    vector<Edge> arestas_min = runKruskalAlgorithm(edges, qtd_vertices);
 
    peso = 0;
    for(i = 0; i < (int)arestas_min.size(); i++) {
        peso += arestas_min[i].weight;
    }
 
    printf("%d", peso);

    return 0;
}
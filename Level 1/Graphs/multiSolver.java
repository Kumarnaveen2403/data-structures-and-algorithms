public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      if(src == dest){
            if(wsf < spathwt){
                spathwt = wsf;
                spath = psf;
            }

            if(wsf > lpathwt){
                lpathwt = wsf;
                lpath = psf;
            }

            if(wsf < cpathwt && wsf > criteria){
                cpath = psf;
                cpathwt = wsf;
            }
            if(wsf > fpathwt && wsf < criteria){
                fpath = psf;
                fpathwt = wsf;
            }

                     if(pq.size() < k){
                pq.add(new Pair(wsf, psf));
            } else {
                if(wsf > pq.peek().wsf){
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            return;
        }

        visited[src] = true;
        for(int i = 0; i < graph[src].size(); i++){
            Edge edge = graph[src].get(i);
            int nbr =  edge.nbr;
        
            if(visited[nbr] == false){
                 multisolver(graph, nbr, dest, visited, criteria, k, psf + nbr + "", wsf + edge.wt);
            }
        }
        visited[src] = false;
   }
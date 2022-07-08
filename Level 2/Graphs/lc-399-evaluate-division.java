class Solution {
    HashMap<String, String> parent;
    HashMap<String, Double> mult;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        mult = new HashMap<>();
        double[] ans = new double[queries.size()];
        
        for(List<String> equation : equations){
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            
            if(parent.containsKey(s1) == false){
                parent.put(s1, s1);
                mult.put(s1, 1.0);
            }
            
            if(parent.containsKey(s2) == false){
                parent.put(s2, s2);
                mult.put(s2, 1.0);
            }
        }
        
        int count = 0;
        for(List<String> equation : equations){
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            double val = values[count];
            
            String lead1 = find(s1);
            String lead2 = find(s2);
            
            if(lead1.equals(lead2) == false){
                parent.put(lead2, lead1);
                double m1 = ( mult.get(s1) * val ) / mult.get(s2);
                mult.put(lead2, m1);
            }
            
            count++;
        }
        
        count = 0;
        for(List<String> query : queries){
            String s1 = query.get(0);
            String s2 = query.get(1);
            
            if(parent.containsKey(s1) == false || parent.containsKey(s2) == false){
                ans[count] = -1.0;
                count++;
                continue;
            }
            
            String lead1 = find(s1);
            String lead2 = find(s2);
            
            if(lead1.equals(lead2) == false){
                ans[count] = -1.0;
                count++;
                continue;
            }
            
            double m = mult.get(s2) / mult.get(s1);
            ans[count] = m;
            
            count++;
        }
        
        
        return ans;
    }
    
    public String find(String x){
        if(parent.get(x).equals(x) == true){
            return x;
        } else {
            String currParent = parent.get(x);
            String lead = find(parent.get(x));
            
            double m = mult.get(x) * mult.get(currParent);
            parent.put(x, lead);
            mult.put(x, m);
            
            return lead;
        }
    }
}
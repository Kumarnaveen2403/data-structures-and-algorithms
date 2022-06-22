Scanner scn = new Scanner(System.in);

int n1 = scn.nextInt();
int[] arr1 = new int[n1];
for(int i = 0; i < n1; i++){
    arr1[i] = scn.nextInt();
}

int n2 = scn.nextInt();
int[] arr2 = new int[n2];
for(int i = 0; i < n2; i++){
    arr2[i] = scn.nextInt();
}

HashMap<Integer, Integer> h1 = new HashMap<>();
for(int i = 0; i < n1; i++){
    if(h1.containsKey(arr1[i]) == false){
        h1.put(arr1[i], 1);
    } else {
        int f = h1.get(arr1[i]);
        h1.put(arr1[i], f + 1);
    }
}

for(int i = 0; i < arr2.length; i++){
    if(h1.containsKey(arr2[i]) == true){
        System.out.println(arr2[i]);
        h1.remove(arr2[i]);
    }
}

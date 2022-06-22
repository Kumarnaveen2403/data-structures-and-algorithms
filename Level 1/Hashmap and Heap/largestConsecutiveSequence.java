Scanner scn = new Scanner(System.in);

int n = scn.nextInt();
int[] arr = new int[n];
for(int i = 0; i < n; i++){
    arr[i] = scn.nextInt();
}

HashMap<Integer, Boolean> hm = new HashMap<>();

for(int i = 0; i < arr.length; i++){
    hm.put(arr[i], true);
}

for(int i = 0; i < arr.length; i++){
    if(hm.containsKey(arr[i] - 1) == true){
        hm.put(arr[i], false);
    }
}

int maxlen = 0;
int el = -1;

for(int i = 0; i < arr.length; i++){
    if(hm.get(arr[i]) == true){
        int tel = arr[i];
        int tlen = 1;
        while(hm.containsKey(tel + tlen) == true){
            tlen++;
        }

        if(tlen > maxlen){
            maxlen = tlen;
            el = tel;
        }
    }
}

for(int i = 0; i < maxlen; i++){
    System.out.println(el + i);
}
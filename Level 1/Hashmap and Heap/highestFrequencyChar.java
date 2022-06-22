Scanner scn = new Scanner(System.in);
String str = scn.nextLine();

HashMap<Character, Integer> hm = new HashMap<>();

for(int i = 0; i < str.length(); i++){
    Integer f = hm.get(str.charAt(i));
    char ch = str.charAt(i);
    
    if(f == null){
        hm.put(ch, 1);
    } else {
        hm.put(ch, f + 1);
    }
}

Set<Character> keys = hm.keySet();

char maxChar = str.charAt(0);
int max = 0;
for(char key : keys){
    int f = hm.get(key);

    if(f > max){
        max = f;
        maxChar = key;
    }
}

System.out.println(maxChar);
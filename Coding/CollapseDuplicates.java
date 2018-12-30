    public static String collapseDuplicates(String a) {
        if(a==null||a.length()<2){
            return a;
        }
        StringBuilder strBuild=new StringBuilder();
        int slow=0,fast=0;

        strBuild.append(a.charAt(slow));

        while(fast<a.length()){
            if(a.charAt(slow)!=a.charAt(fast)){
                strBuild.append(a.charAt(fast));
                slow=fast;
            }else{
                fast++;
            }
        }
        return strBuild.toString();
    }

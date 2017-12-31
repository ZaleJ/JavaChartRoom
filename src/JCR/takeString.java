package JCR;

public class takeString {
    //static String msg = "欢迎【shabi】进入聊天室！当前聊天室有【12】人";
    //static String name="", number="";

    public String takeName(String msg1){
        String name="", number="";
        int tag =0;
        int j;
        for (int i = 0; i < msg1.length(); i++){
            if (msg1.charAt(i)=='【' && tag!=1){
                j=i+1;
                while (j<msg1.length() && msg1.charAt(j)!='】'){
                    name+=msg1.charAt(j);
                    j++;
                }
                i++;
                tag=1;
            }

            if (msg1.charAt(i)=='【' && tag!=0){
                j=i+1;
                while (j<msg1.length() && msg1.charAt(j)!='】'){
                    number+=msg1.charAt(j);
                    j++;
                }
            }
        }
        return name;
    }

    public String takeNumber(String msg1){
        String name="", number="";
        int tag =0;
        int j;
        for (int i = 0; i < msg1.length(); i++){
            if (msg1.charAt(i)=='【' && tag!=1){
                j=i+1;
                while (j<msg1.length() && msg1.charAt(j)!='】'){
                    name+=msg1.charAt(j);
                    j++;
                }
                i++;
                tag=1;
            }

            if (msg1.charAt(i)=='【' && tag!=0){
                j=i+1;
                while (j<msg1.length() && msg1.charAt(j)!='】'){
                    number+=msg1.charAt(j);
                    j++;
                }
            }
        }
        return number;
    }
}

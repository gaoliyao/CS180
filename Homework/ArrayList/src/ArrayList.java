/**
 * Created by mars on 4/10/18.
 */
public class ArrayList {
    String[] strs = null;
    int size = -1;
    public ArrayList(){
        strs = new String[100];
        size = 100;
    }
    public ArrayList(String[] strs){
        this.strs = strs;
        size = strs.length;
    }
    public ArrayList(int size){
        strs = new String[size];
        this.size = size;
    }

    public boolean add(String addItem){
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null){
                strs[i] = addItem;
                return true;
            }
        }
        return false;
    }


    public boolean delete(String delItem){
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(delItem)){
                strs[i] = null;
                for (int j=i;j<strs.length-1;j++){
                    strs[j] = strs[j+1];
                }
                return true;
            }
        }
        return false;
    }


    public boolean replace(int index, String replaceItem){
        for (int i = 0; i < strs.length; i++) {
            if (i == index){
                strs[i] = replaceItem;
                return true;
            }
        }
        return false;
    }


    public int search(String searchItem){
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(searchItem)){
                return i;
            }
        }
        return -1;
    }

    public String get(int i){
        return strs[i];
    }

    public boolean set(int i, String str){
        strs[i] = str;
        return true;
    }

    public String toString(){
        String output = "";
        for (String str: strs){
            if (str != null)
                output += str + "\n";
        }
        return output;
    }
}


package classes;

/*
ben
 */
public class Genre {
    //p
    private int id;
    private String name;
    //c
    public Genre(){
        
    }
    public Genre(int id, String name){
        this.id = id;
        this.name = name;
    }
    //g&s

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //m

    @Override
    public String toString() {
        return name;
    }
    
    
}

package statistics.matcher;

public class QueryBuilder {
    
    Matcher m;
    
    public QueryBuilder(){
        m = new All();
    }
    
    public QueryBuilder(Matcher m){
        this.m = m;
    }
    
    public QueryBuilder oneOf(Matcher...matchers){
        return new QueryBuilder(new Or(matchers));
    }
    
    public QueryBuilder playsIn(String team) {
     
        return new QueryBuilder(new And(m, new PlaysIn(team)));
    }
    
    public QueryBuilder hasAtLeast(int h, String w) {
        return new QueryBuilder(new And(m, new HasAtLeast(h, w)));
    }
    
    public QueryBuilder hasFewerThan(int h, String w) {
   
        return new QueryBuilder(new And(m, new HasFewerThan(h, w)));
    }

    public Matcher build() {
        return m;
    }
   
}

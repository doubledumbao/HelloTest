import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int CACHE_SIZE ;

    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75) + 1,0.75f,true);
        this.CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>CACHE_SIZE;
    }

    public static void main(String[] args) {
        System.out.println(1000/0.75);

        int ceil = (int)Math.ceil(1000 / 0.75);
        System.out.println(ceil);
    }
}

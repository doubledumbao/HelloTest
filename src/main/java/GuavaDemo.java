import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author doubledumbao
 */
public class GuavaDemo {

    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, User> userCache = CacheBuilder.newBuilder().concurrencyLevel(8)
                .initialCapacity(10)
                .maximumSize(100)
                .expireAfterWrite(8, TimeUnit.SECONDS)
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .recordStats()
                .removalListener(new RemovalListener<String, User>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, User> removalNotification) {
                        System.out.println(removalNotification.getKey() + "被移除了，原因是：" + removalNotification.getCause());
                    }
                }).build(new CacheLoader<String, User>() {
                    @Override
                    public User load(String s) throws Exception {
                        System.out.println("缓存没有时，从数据库加载 --"+s);
                        return new User(s,s);
                    }
                });
        System.out.println("--------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(userCache.get("user" + i));
        }
        System.out.println("--------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(userCache.get("user" + i));
        }
        System.out.println("hitcount:"+userCache.stats().hitCount()+",miscount:"+userCache.stats().missCount());
    }

    private static class User {
        private String id;
        private String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

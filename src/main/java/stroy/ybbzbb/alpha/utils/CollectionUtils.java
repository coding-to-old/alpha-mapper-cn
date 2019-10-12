package stroy.ybbzbb.alpha.utils;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * @Description TODO
 */
public class CollectionUtils {

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}

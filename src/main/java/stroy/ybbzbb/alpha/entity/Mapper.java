package stroy.ybbzbb.alpha.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Description mapper
 * @Date 2019-09-30
 * @author ybbzbb
 */
@Getter
@Setter
@Builder
public class Mapper {

    @SerializedName("shortName")
    private String name;

    private MapperLevel lever;

    private List<Mapper> child;

    public static enum MapperLevel{
        COUNTRY,PROVINCE,CITY,AREA;
    }

}

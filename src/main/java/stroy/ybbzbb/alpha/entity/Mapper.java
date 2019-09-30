package stroy.ybbzbb.alpha.entity;

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

    private String name;

    private MapperLevel lever;

    private List<Mapper> children;

    public static enum MapperLevel{
        COUNTRY,PROVINCE,CITY,AREA;
    }

}

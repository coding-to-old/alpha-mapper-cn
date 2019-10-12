package stroy.ybbzbb.alpha;


import com.google.common.base.Stopwatch;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import stroy.ybbzbb.alpha.entity.Mapper;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description 初始化地图
 * @Date 2019-09-30
 * @author ybbzbb
 */
public class InitMapper {

    private static final boolean lazy = false;

    private static final String FILE_NAME = "map.json";

    public void start(){

        if (lazy) {
            return;
        }

        Stopwatch record = Stopwatch.createUnstarted();
        record.start();


        ClassLoader classLoader = InitMapper.class.getClassLoader();
        URL resource = classLoader.getResource(FILE_NAME);

        assertThat(resource == null).withFailMessage("文件查找不到 %s" , FILE_NAME).isEqualTo(false);

        File file = new File(resource.getPath());

        StringBuffer mapperBuffer = new StringBuffer();
        try(
                final FileInputStream fileInput = new FileInputStream(file);
                final InputStreamReader input = new InputStreamReader(fileInput,"UTF8");
                final BufferedReader buffere = new BufferedReader(input);
        ){

            String str;

            while ((str = buffere.readLine()) != null) {
                mapperBuffer.append(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(StringUtils.isBlank(mapperBuffer.toString()))
                .withFailMessage("文件读取错误")
                .isEqualTo(false);

        List<Mapper> mappers = new Gson().fromJson(mapperBuffer.toString() , new TypeToken<ArrayList<Mapper>>() {}.getType());


        System.out.println(mappers.size());
        System.out.println(mapperBuffer.toString());
    }




}

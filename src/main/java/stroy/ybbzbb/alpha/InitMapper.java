package stroy.ybbzbb.alpha;


import com.google.common.base.Stopwatch;
import org.springframework.util.CollectionUtils;

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

    private static final String FILE_NAME = "pca.csv";


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


        List<String> mapperData = new ArrayList<>(3250);
        try(
                final FileInputStream fileInput = new FileInputStream(file);
                final InputStreamReader input = new InputStreamReader(fileInput,"UTF8");
                final BufferedReader buffere = new BufferedReader(input);
        ){

            String str;

            while ((str = buffere.readLine()) != null) {
                mapperData.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(CollectionUtils.isEmpty(mapperData)).withFailMessage("文件读取错误").isEqualTo(false);


        System.out.println(" " + record.toString());





    }




}

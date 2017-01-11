import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import phrases.PhraseFinder;
import phrases.config.DevConfig;
import phrases.config.RootConfig;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = {RootConfig.class,DevConfig.class, PhraseFinder.class})
public class PhraseFinderTest {

    @Autowired
    PhraseFinder phraseFinder;

    @Autowired
    private JavaSparkContext sc;

    @Test
    public void testPF() throws Exception {
        List<String> list = Arrays.asList("Java it's cool", "Scala the Groovy the groovy", "pascal kotlin");
        JavaRDD<String> rdd = sc.parallelize(list);
        List<String> pf = phraseFinder.phraseList(rdd, "java");
        Assert.assertEquals("[java it's cool]", pf.toString());
    }
}
